package com.jonathan.prueba.domain.tickets.gateway;

import com.jonathan.prueba.domain.tickets.model.Tickets;
import org.springframework.data.domain.Page;

public interface TicketsRepository {

    Tickets crearTicket (Tickets ticketsAdd);

    Tickets editarTicket (Long id , Tickets ticketsAdd);

    void eliminarTicket(Long id);

    Page<Tickets>obtenerTicket(int pagina, int tamano);

    Tickets obtenerTicketsId(Long id);

}
