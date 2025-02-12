package com.jonathan.prueba.domain.estatus.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estatus {

    private Long estadoId;
    private String nombreEstado;
}
