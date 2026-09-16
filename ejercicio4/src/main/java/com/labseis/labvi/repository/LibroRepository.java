package com.labseis.labvi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.labseis.labvi.model.Libro;

@Repository
public class LibroRepository {

    private final List<Libro> libros = new ArrayList<>();
    private final AtomicLong secuenciaId = new AtomicLong(0);

    public Libro guardar(Libro libro) {
        if (libro.getId() == null) {
            libro.setId(secuenciaId.incrementAndGet());
            libros.add(libro);
        }
        return libro;
    }

    public List<Libro> buscarTodos() {
        return libros;
    }

    public Optional<Libro> buscarPorId(Long id) {
        return libros.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public Optional<Libro> buscarPorTitulo(String titulo) {
        return libros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst();
    }

    public Optional<Libro> buscarPorIsbn(String isbn) {
        return libros.stream().filter(l -> l.getIsbn().equalsIgnoreCase(isbn)).findFirst();
    }

    public void eliminar(Libro libro) {
        libros.remove(libro);
    }
}
