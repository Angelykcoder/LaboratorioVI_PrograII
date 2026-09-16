package com.labseis.labvi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.labseis.labvi.dto.CursoRequest;
import com.labseis.labvi.dto.CursoResponse;
import com.labseis.labvi.exception.RecursoDuplicadoException;
import com.labseis.labvi.exception.RecursoNoEncontradoException;
import com.labseis.labvi.model.Curso;
import com.labseis.labvi.model.EstadoCurso;
import com.labseis.labvi.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public CursoResponse crear(CursoRequest request) {
        cursoRepository.buscarPorCodigo(request.getCodigo()).ifPresent(c -> {
            throw new RecursoDuplicadoException("Ya existe un curso con el código: " + request.getCodigo());
        });

        Curso curso = new Curso();
        curso.setNombre(request.getNombre());
        curso.setCodigo(request.getCodigo());
        curso.setCreditos(request.getCreditos());
        curso.setEstado(EstadoCurso.ACTIVO);

        return convertirAResponse(cursoRepository.guardar(curso));
    }

    @Override
    public List<CursoResponse> listarTodos() {
        return cursoRepository.buscarTodos().stream()
                .map(this::convertirAResponse)
                .toList();
    }

    @Override
    public CursoResponse buscarPorCodigo(String codigo) {
        Curso curso = cursoRepository.buscarPorCodigo(codigo)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró un curso con el código: " + codigo));
        return convertirAResponse(curso);
    }

    @Override
    public CursoResponse actualizar(Long id, CursoRequest request) {
        Curso curso = cursoRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró un curso con id: " + id));

        cursoRepository.buscarPorCodigo(request.getCodigo())
                .filter(c -> !c.getId().equals(id))
                .ifPresent(c -> {
                    throw new RecursoDuplicadoException("Ya existe un curso con el código: " + request.getCodigo());
                });

        curso.setNombre(request.getNombre());
        curso.setCodigo(request.getCodigo());
        curso.setCreditos(request.getCreditos());

        return convertirAResponse(curso);
    }

    @Override
    public void eliminar(Long id) {
        Curso curso = cursoRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró un curso con id: " + id));
        cursoRepository.eliminar(curso);
    }

    private CursoResponse convertirAResponse(Curso curso) {
        return new CursoResponse(curso.getId(), curso.getNombre(), curso.getCodigo(), curso.getCreditos(),
                curso.getEstado());
    }
}
