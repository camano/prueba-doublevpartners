package com.jonathan.prueba.infrastructure.adapter.postgres.mapper;

import com.jonathan.prueba.domain.estatus.models.Estatus;
import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.infrastructure.adapter.postgres.entity.EstatusEntity;
import com.jonathan.prueba.infrastructure.adapter.postgres.entity.TicketsEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperDto {

    public Tickets mapEntityTickets(TicketsEntity tickets){
        return Tickets.builder()
                .id(tickets.getId())
                .usuario(tickets.getUsuario())
                .fechaCreacion(tickets.getFechaCreacion())
                .fechaActualizacion(tickets.getFechaActualizacion())
                .estatus(Estatus.builder()
                        .estadoId(tickets.getEstatusId().getEstatusId())
                        .nombreEstado(tickets.getEstatusId().getNombreEstatus())
                        .build())
                .build();
    }

    public TicketsEntity mapTicketsEntity(Tickets tickets){
        return TicketsEntity.builder()
                .id(tickets.getId())
                .usuario(tickets.getUsuario())
                .fechaCreacion(tickets.getFechaCreacion())
                .fechaActualizacion(tickets.getFechaActualizacion())
                .estatusId(EstatusEntity.builder()
                        .estatusId(tickets.getEstatus().getEstadoId())
                        .nombreEstatus(tickets.getEstatus().getNombreEstado())
                        .build())
                .build();
    }

    public Estatus mapEntityEstatus(EstatusEntity estatus){
        return Estatus.builder()
                .nombreEstado(estatus.getNombreEstatus())
                .estadoId(estatus.getEstatusId())
                .build();
    }



}
