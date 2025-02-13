package com.jonathan.prueba.domain.tickets.gateway;

import com.jonathan.prueba.domain.tickets.model.Tickets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketsRepository {

    Tickets crearTicket (Tickets ticketsAdd);

    Tickets editarTicket (Long id , Tickets ticketsAdd);

    void eliminarTicket(Long id);

    Page<Tickets>obtenerTicket(Pageable pageable);

    Tickets obtenerTicketsId(Long id);

    Page<Tickets>obtenerTicketEstatus(Long estatus,Pageable pageable);

}
