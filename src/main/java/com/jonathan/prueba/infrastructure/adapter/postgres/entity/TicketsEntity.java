package com.jonathan.prueba.infrastructure.adapter.postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tickets")
public class TicketsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id ;

    @Column()
    private String usuario;

    @Column
    private LocalDate fechaCreacion;

    @Column
    private LocalDate fechaActualizacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estatusIdTickets",nullable = false)
    private EstatusEntity estatusId;
}
