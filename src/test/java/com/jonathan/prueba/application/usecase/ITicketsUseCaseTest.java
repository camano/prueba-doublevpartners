package com.jonathan.prueba.application.usecase;

import com.jonathan.prueba.domain.estatus.gateway.EstatusRepository;
import com.jonathan.prueba.domain.estatus.models.Estatus;
import com.jonathan.prueba.domain.tickets.gateway.TicketsRepository;
import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ITicketsUseCaseTest {

    @Mock
    private TicketsRepository ticketsRepository;

    @Mock
    private EstatusRepository estatusRepository;

    @InjectMocks
    private ITicketsUseCase ticketsUseCase;

    private TicketsBody ticketsBody;
    private Tickets tickets;
    private Estatus estatus;
    private Tickets ticketsUpdate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        estatus=new Estatus(1L,"abierto");
        tickets=new Tickets(1L,"mock", LocalDate.now(),LocalDate.now(),estatus);
        ticketsBody=new TicketsBody(1L,"mock","mock",LocalDate.now(),LocalDate.now());
        ticketsUpdate = tickets=new Tickets(1L,"mock", LocalDate.now(),LocalDate.now(),estatus);



    }

    @Test
    void addTickets() {
        when(estatusRepository.findByNombre("abierto")).thenReturn(estatus);
        when(ticketsRepository.crearTicket(tickets)).thenReturn(tickets);

        TicketsResponse ticketsResponse=ticketsUseCase.addTickets(ticketsBody);
        assertEquals(1L,ticketsResponse.getId());

    }

    @Test
    void findByTicketsId() {
        when(ticketsRepository.obtenerTicketsId(1L)).thenReturn(tickets);
        TicketsResponse ticketsResponse = ticketsUseCase.findByTicketsId(1L);
        assertEquals(1L,ticketsResponse.getId());
    }

 /*  @Test
    void updateTickets() {
        when(ticketsRepository.obtenerTicketsId(1L)).thenReturn(ticketsUpdate);
        when(estatusRepository.findByNombre("abierto")).thenReturn(estatus);
        when(ticketsRepository.crearTicket(ticketsUpdate)).thenReturn(tickets);

        TicketsResponse ticketsResponse= ticketsUseCase.updateTickets(1L,ticketsBody);

        assertEquals("mock",ticketsResponse.getUsuario());
    }*/

    @Test
    void deleteTickets() {
        ticketsRepository.eliminarTicket(1L);
    }

}