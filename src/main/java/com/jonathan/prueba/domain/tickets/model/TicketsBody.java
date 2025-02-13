package com.jonathan.prueba.domain.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketsBody {
    private Long id;
    private String usuario;
    private String estatus;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;

}
