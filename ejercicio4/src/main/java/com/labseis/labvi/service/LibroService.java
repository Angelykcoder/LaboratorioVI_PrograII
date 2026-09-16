package com.labseis.labvi.service;

import java.util.List;

import com.labseis.labvi.dto.LibroRequest;
import com.labseis.labvi.dto.LibroResponse;

public interface LibroService {

    LibroResponse crear(LibroRequest request);

    List<LibroResponse> listarTodos();

    LibroResponse buscarPorTitulo(String titulo);

    LibroResponse actualizar(Long id, LibroRequest request);

    void eliminar(Long id);
}
