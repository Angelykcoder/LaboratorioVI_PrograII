package com.labseis.labvi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.labseis.labvi.dto.ReservaRequest;
import com.labseis.labvi.dto.ReservaResponse;
import com.labseis.labvi.exception.RecursoNoEncontradoException;
import com.labseis.labvi.model.EstadoReserva;
import com.labseis.labvi.model.Reserva;
import com.labseis.labvi.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public ReservaResponse crear(ReservaRequest request) {
        validarFechas(request);

        Reserva reserva = new Reserva();
        reserva.setNombreCliente(request.getNombreCliente());
        reserva.setHabitacion(request.getHabitacion());
        reserva.setFechaEntrada(request.getFechaEntrada());
        reserva.setFechaSalida(request.getFechaSalida());
        reserva.setEstado(EstadoReserva.CONFIRMADA);

        return convertirAResponse(reservaRepository.guardar(reserva));
    }

    @Override
    public List<ReservaResponse> listarTodos() {
        return reservaRepository.buscarTodos().stream()
                .map(this::convertirAResponse)
                .toList();
    }

    @Override
    public ReservaResponse buscarPorId(Long id) {
        Reserva reserva = reservaRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una reserva con id: " + id));
        return convertirAResponse(reserva);
    }

    @Override
    public ReservaResponse actualizar(Long id, ReservaRequest request) {
        validarFechas(request);

        Reserva reserva = reservaRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una reserva con id: " + id));

        reserva.setNombreCliente(request.getNombreCliente());
        reserva.setHabitacion(request.getHabitacion());
        reserva.setFechaEntrada(request.getFechaEntrada());
        reserva.setFechaSalida(request.getFechaSalida());

        return convertirAResponse(reserva);
    }

    @Override
    public ReservaResponse cancelar(Long id) {
        Reserva reserva = reservaRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una reserva con id: " + id));
        reserva.setEstado(EstadoReserva.CANCELADA);
        return convertirAResponse(reserva);
    }

    private void validarFechas(ReservaRequest request) {
        if (!request.getFechaSalida().isAfter(request.getFechaEntrada())) {
            throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de entrada");
        }
    }

    private ReservaResponse convertirAResponse(Reserva reserva) {
        return new ReservaResponse(reserva.getId(), reserva.getNombreCliente(), reserva.getHabitacion(),
                reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getEstado());
    }
}
