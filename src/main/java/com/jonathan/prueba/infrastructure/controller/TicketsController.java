package com.jonathan.prueba.infrastructure.controller;

import com.jonathan.prueba.application.service.TicketsService;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {

    private final TicketsService ticketsService;

    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping
    public String mensaje(){
        return "pruebas";
    }

    @PostMapping
    public ResponseEntity<?>agregarTickets(@RequestBody TicketsBody ticketsBody){
        return new ResponseEntity<>(ticketsService.addTickets(ticketsBody), HttpStatus.OK);
    }

    @GetMapping("/{tickeId}")
    public ResponseEntity<?> buscarTarea(@PathVariable Long tickeId){
        return new ResponseEntity<>(ticketsService.findByTicketsId(tickeId),HttpStatus.OK);
    }
}
