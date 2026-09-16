package com.labseis.labvi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.labseis.labvi.model.Curso;

@Repository
public class CursoRepository {

    private final List<Curso> cursos = new ArrayList<>();
    private final AtomicLong secuenciaId = new AtomicLong(0);

    public Curso guardar(Curso curso) {
        if (curso.getId() == null) {
            curso.setId(secuenciaId.incrementAndGet());
            cursos.add(curso);
        }
        return curso;
    }

    public List<Curso> buscarTodos() {
        return cursos;
    }

    public Optional<Curso> buscarPorId(Long id) {
        return cursos.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Optional<Curso> buscarPorCodigo(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }

    public void eliminar(Curso curso) {
        cursos.remove(curso);
    }
}
