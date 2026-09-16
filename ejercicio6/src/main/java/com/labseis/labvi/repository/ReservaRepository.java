package com.labseis.labvi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.labseis.labvi.model.Reserva;

@Repository
public class ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();
    private final AtomicLong secuenciaId = new AtomicLong(0);

    public Reserva guardar(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva.setId(secuenciaId.incrementAndGet());
            reservas.add(reserva);
        }
        return reserva;
    }

    public List<Reserva> buscarTodos() {
        return reservas;
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservas.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
