package com.labseis.labvi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.labseis.labvi.dto.LibroRequest;
import com.labseis.labvi.dto.LibroResponse;
import com.labseis.labvi.exception.RecursoDuplicadoException;
import com.labseis.labvi.exception.RecursoNoEncontradoException;
import com.labseis.labvi.model.EstadoLibro;
import com.labseis.labvi.model.Libro;
import com.labseis.labvi.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroResponse crear(LibroRequest request) {
        libroRepository.buscarPorIsbn(request.getIsbn()).ifPresent(l -> {
            throw new RecursoDuplicadoException("Ya existe un libro con el ISBN: " + request.getIsbn());
        });

        Libro libro = new Libro();
        libro.setTitulo(request.getTitulo());
        libro.setAutor(request.getAutor());
        libro.setIsbn(request.getIsbn());
        libro.setAnioPublicacion(request.getAnioPublicacion());
        libro.setEstado(EstadoLibro.DISPONIBLE);

        return convertirAResponse(libroRepository.guardar(libro));
    }

    @Override
    public List<LibroResponse> listarTodos() {
        return libroRepository.buscarTodos().stream()
                .map(this::convertirAResponse)
                .toList();
    }

    @Override
    public LibroResponse buscarPorTitulo(String titulo) {
        Libro libro = libroRepository.buscarPorTitulo(titulo)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró un libro con el título: " + titulo));
        return convertirAResponse(libro);
    }

    @Override
    public LibroResponse actualizar(Long id, LibroRequest request) {
        Libro libro = libroRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró un libro con id: " + id));

        libroRepository.buscarPorIsbn(request.getIsbn())
                .filter(l -> !l.getId().equals(id))
                .ifPresent(l -> {
                    throw new RecursoDuplicadoException("Ya existe un libro con el ISBN: " + request.getIsbn());
                });

        libro.setTitulo(request.getTitulo());
        libro.setAutor(request.getAutor());
        libro.setIsbn(request.getIsbn());
        libro.setAnioPublicacion(request.getAnioPublicacion());

        return convertirAResponse(libro);
    }

    @Override
    public void eliminar(Long id) {
        Libro libro = libroRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró un libro con id: " + id));
        libroRepository.eliminar(libro);
    }

    private LibroResponse convertirAResponse(Libro libro) {
        return new LibroResponse(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getIsbn(),
                libro.getAnioPublicacion(), libro.getEstado());
    }
}
