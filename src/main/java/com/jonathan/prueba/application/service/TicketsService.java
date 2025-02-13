package com.jonathan.prueba.application.service;

import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;
import com.jonathan.prueba.domain.tickets.usecase.TicketsUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketsService implements TicketsUseCase {

    private final TicketsUseCase ticketsUseCase;

    public TicketsService(TicketsUseCase ticketsUseCase) {
        this.ticketsUseCase = ticketsUseCase;
    }

    @Override
    public TicketsResponse addTickets(TicketsBody ticketsBody) {
        return ticketsUseCase.addTickets(ticketsBody);
    }

    @Override
    public TicketsResponse findByTicketsId(Long id) {
        return ticketsUseCase.findByTicketsId(id);
    }

    @Override
    public TicketsResponse updateTickets(Long id, TicketsBody ticketsBody) {
        return ticketsUseCase.updateTickets(id,ticketsBody);
    }

    @Override
    public void deleteTickets(Long id) {
         ticketsUseCase.deleteTickets(id);
    }

    @Override
    public Page<TicketsResponse> findByAll(Pageable pageable) {
        return ticketsUseCase.findByAll(pageable);
    }

    @Override
    public Page<TicketsResponse> findByAllEstatus(String estatus, Pageable pageable) {
        return ticketsUseCase.findByAllEstatus(estatus,pageable);
    }


}
