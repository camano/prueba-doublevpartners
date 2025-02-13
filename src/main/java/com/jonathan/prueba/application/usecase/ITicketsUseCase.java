package com.jonathan.prueba.application.usecase;

import com.jonathan.prueba.domain.estatus.gateway.EstatusRepository;
import com.jonathan.prueba.domain.estatus.models.Estatus;
import com.jonathan.prueba.domain.tickets.gateway.TicketsRepository;
import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;
import com.jonathan.prueba.domain.tickets.usecase.TicketsUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        ticketsBody.setFechaCreacion(LocalDate.from(LocalDate.now()));
        Tickets tickets = ticketsRepository.crearTicket(mapperTickets(ticketsBody,estatus));
        return mapperTicketsResponse(tickets);
    }

    @Override
    public TicketsResponse findByTicketsId(Long id) {
        return mapperTicketsResponse(ticketsRepository.obtenerTicketsId(id));
    }

    @Override
    public TicketsResponse updateTickets(Long id, TicketsBody ticketsBody) {
            Tickets ticketsExiste= ticketsRepository.obtenerTicketsId(id);

            Estatus estatus = estatusRepository.findByNombre(ticketsBody.getEstatus());
            ticketsBody.setId(ticketsExiste.getId());
            ticketsBody.setFechaCreacion(ticketsExiste.getFechaCreacion());
            ticketsBody.setFechaActualizacion(LocalDate.from(LocalDate.now()));
            Tickets tickets = ticketsRepository.crearTicket(mapperTickets(ticketsBody,estatus));
            return mapperTicketsResponse(tickets);

    }

    @Override
    public void deleteTickets(Long id) {
        ticketsRepository.eliminarTicket(id);

    }

    @Override
    public Page<TicketsResponse> findByAll(Pageable pageable) {
        return ticketsRepository.obtenerTicket(pageable)
                .map(this::mapperTicketsResponse);
    }

    @Override
    public Page<TicketsResponse> findByAllEstatus(String estatus, Pageable pageable) {
        Estatus estatu = estatusRepository.findByNombre(estatus);
        return ticketsRepository.obtenerTicketEstatus(estatu.getEstadoId(),pageable)
                .map(this::mapperTicketsResponse);
    }


    public Tickets mapperTickets(TicketsBody ticketsBody,Estatus estatus){
        return Tickets.builder()
                .id(ticketsBody.getId())
                .usuario(ticketsBody.getUsuario())
                .fechaCreacion(ticketsBody.getFechaCreacion())
                .fechaActualizacion(ticketsBody.getFechaActualizacion())
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
