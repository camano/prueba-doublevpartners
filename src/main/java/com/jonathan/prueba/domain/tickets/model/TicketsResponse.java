package com.jonathan.prueba.domain.tickets.model;

import com.jonathan.prueba.domain.estatus.models.Estatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketsResponse {

    private Long id;
    private String usuario;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;
    private String estatus;
}
