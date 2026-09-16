package com.labseis.labvi.service;

import java.util.List;

import com.labseis.labvi.dto.CursoRequest;
import com.labseis.labvi.dto.CursoResponse;

public interface CursoService {

    CursoResponse crear(CursoRequest request);

    List<CursoResponse> listarTodos();

    CursoResponse buscarPorCodigo(String codigo);

    CursoResponse actualizar(Long id, CursoRequest request);

    void eliminar(Long id);
}
