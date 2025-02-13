package com.jonathan.prueba.infrastructure.controller;

import com.jonathan.prueba.application.service.TicketsService;
import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.domain.tickets.model.TicketsBody;
import com.jonathan.prueba.domain.tickets.model.TicketsResponse;
import com.jonathan.prueba.infrastructure.controller.models.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {

    private final TicketsService ticketsService;

    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    //------------------------- Crear  Tickets ---------------------------
    @Operation(description = "End point para crear un nuevo tickets")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Generar un nuevo tickets ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))
                    }
            )
    })
    @PostMapping
    public ResponseEntity<ApiResponse<TicketsResponse>>agregarTickets(@RequestBody TicketsBody ticketsBody){
        return new ResponseEntity<>(new ApiResponse<>("Se agrego un nuevo ticket ",ticketsService.addTickets(ticketsBody)), HttpStatus.CREATED);
    }

    //------------------------- Buscar Tickets x id  ---------------------------

    @Operation(description = "End point para buscar x id ")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Consultar ticket por id ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))
                    }
            )
    })
    @GetMapping("/{tickeId}")
    public ResponseEntity<ApiResponse<TicketsResponse>> buscarTickets(@PathVariable Long tickeId){
        TicketsResponse ticketsResponse = ticketsService.findByTicketsId(tickeId);
        return new ResponseEntity<>(new ApiResponse<>("ticket encontrado " + ticketsResponse.getId(),ticketsResponse),HttpStatus.OK);
    }

    //------------------------- Editar Tickets ---------------------------

    @Operation(description = "End point para actualizar el ticket o estado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Actualizar  ticket x id ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TicketsResponse.class))
                    }
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TicketsResponse>>editarTickets(@PathVariable Long id,@RequestBody TicketsBody ticketsBody){
        return new ResponseEntity<>(new ApiResponse<>("Se edito el ticket "+ id,ticketsService.updateTickets(id,ticketsBody)), HttpStatus.OK);
    }

    //------------------------- Eliminar Tickets ---------------------------

    @Operation(description = "End point para eliminar el ticket")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Eliminar  ticket x id ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TicketsResponse.class))
                    }
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<TicketsResponse>> eliminarTickets(@PathVariable Long id){
        ticketsService.deleteTickets(id);
        return new ResponseEntity<>(new ApiResponse<>("se elimino  el ticket  " + id,null),HttpStatus.NO_CONTENT);
    }

    //------------------------- Paginador ver todos los Tickets ---------------------------

    @Operation(description = "End point para ver todo los ticket")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Listar  tickets",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))
                    }
            )
    })
    @GetMapping
    public ResponseEntity<?>tickets(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int size
            ){

        Pageable pageable = PageRequest.of(page,size);
        return new ResponseEntity<>(ticketsService.findByAll(pageable).getContent(),HttpStatus.OK);
    }

    //------------------------- Paginador ver todos los Tickets x estatus---------------------------

    @Operation(description = "End point para ver listar tickets x estatus")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Listar  ticket x estatus ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))
                    }
            )
    })
    @GetMapping("/estatus")
    public ResponseEntity<?>tickestEstatu(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam String estatus

    ){

        Pageable pageable = PageRequest.of(page,size);
        return new ResponseEntity<>(ticketsService.findByAllEstatus(estatus,pageable).getContent(),HttpStatus.OK);
    }

}
