package com.jonathan.prueba.domain.tickets.usecase;

import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketsUseCase {

    TicketsResponse addTickets(TicketsBody ticketsBody);

    TicketsResponse findByTicketsId(Long id);

    TicketsResponse updateTickets(Long id ,TicketsBody ticketsBody);

    void deleteTickets(Long id);

    Page<TicketsResponse> findByAll(Pageable pageable);

    Page<TicketsResponse> findByAllEstatus(String estatus,Pageable pageable);
}
