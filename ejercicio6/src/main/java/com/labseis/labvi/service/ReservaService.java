package com.labseis.labvi.service;

import java.util.List;

import com.labseis.labvi.dto.ReservaRequest;
import com.labseis.labvi.dto.ReservaResponse;

public interface ReservaService {

    ReservaResponse crear(ReservaRequest request);

    List<ReservaResponse> listarTodos();

    ReservaResponse buscarPorId(Long id);

    ReservaResponse actualizar(Long id, ReservaRequest request);

    ReservaResponse cancelar(Long id);
}
