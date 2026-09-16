package com.labseis.labvi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labseis.labvi.dto.CursoRequest;
import com.labseis.labvi.dto.CursoResponse;
import com.labseis.labvi.service.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoResponse> crear(@Valid @RequestBody CursoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> listarTodos() {
        return ResponseEntity.ok(cursoService.listarTodos());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<CursoResponse> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(cursoService.buscarPorCodigo(codigo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> actualizar(@PathVariable Long id, @Valid @RequestBody CursoRequest request) {
        return ResponseEntity.ok(cursoService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
