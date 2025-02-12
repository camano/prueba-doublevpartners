package com.jonathan.prueba.domain.tickets.usecase;

import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;

public interface TicketsUseCase {

    TicketsResponse addTickets(TicketsBody ticketsBody);

    TicketsResponse findByTicketsId(Long id);
}
