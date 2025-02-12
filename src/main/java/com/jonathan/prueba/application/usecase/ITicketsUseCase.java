package com.jonathan.prueba.application.usecase;

import com.jonathan.prueba.domain.estatus.gateway.EstatusRepository;
import com.jonathan.prueba.domain.estatus.models.Estatus;
import com.jonathan.prueba.domain.tickets.gateway.TicketsRepository;
import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;
import com.jonathan.prueba.domain.tickets.usecase.TicketsUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ITicketsUseCase implements TicketsUseCase {

    private final TicketsRepository ticketsRepository;

    private final EstatusRepository estatusRepository;

    public ITicketsUseCase(TicketsRepository ticketsRepository, EstatusRepository estatusRepository) {
        this.ticketsRepository = ticketsRepository;
        this.estatusRepository = estatusRepository;
    }


    @Override
    public TicketsResponse addTickets(TicketsBody ticketsBody) {
        Estatus estatus = estatusRepository.findByNombre("abierto");
        Tickets tickets = ticketsRepository.crearTicket(mapperTickets(ticketsBody,estatus));
        return mapperTicketsResponse(tickets);
    }

    @Override
    public TicketsResponse findByTicketsId(Long id) {
        return mapperTicketsResponse(ticketsRepository.obtenerTicketsId(id));
    }


    public Tickets mapperTickets(TicketsBody ticketsBody,Estatus estatus){
        return Tickets.builder()
                .usuario(ticketsBody.getUsuario())
                .fechaCreacion(LocalDate.from(LocalDate.now()))
                .fechaActualizacion(LocalDate.from(LocalDate.now()))
                .estatus(estatus)
                .build();
    }

    public TicketsResponse mapperTicketsResponse(Tickets tickets){
        return TicketsResponse.builder()
                .id(tickets.getId())
                .fechaCreacion(tickets.getFechaCreacion())
                .fechaActualizacion(tickets.getFechaActualizacion())
                .usuario(tickets.getUsuario())
                .estatus(tickets.getEstatus().getNombreEstado())
                .build();
    }
}
