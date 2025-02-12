package com.jonathan.prueba.application.service;

import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;
import com.jonathan.prueba.domain.tickets.usecase.TicketsUseCase;
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
}
