package com.jonathan.prueba.infrastructure.adapter.postgres.repositoryImpl;

import com.jonathan.prueba.domain.tickets.gateway.TicketsRepository;
import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.infrastructure.adapter.postgres.entity.TicketsEntity;
import com.jonathan.prueba.infrastructure.adapter.postgres.mapper.MapperDto;
import com.jonathan.prueba.infrastructure.adapter.postgres.repository.TicketsEntityRepository;
import com.jonathan.prueba.infrastructure.helper.excepciones.Excepciones;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ITicketsRepository  implements TicketsRepository {

    private final TicketsEntityRepository ticketsEntityRepo;

    private final MapperDto mapperDto;

    public ITicketsRepository(TicketsEntityRepository ticketsEntityRepo, MapperDto mapperDto) {
        this.ticketsEntityRepo = ticketsEntityRepo;
        this.mapperDto = mapperDto;
    }

    @Override
    public Tickets crearTicket(Tickets ticketsAdd) {
        try{
            TicketsEntity newTicket = ticketsEntityRepo.save(mapperDto.mapTicketsEntity(ticketsAdd));
            return mapperDto.mapEntityTickets(newTicket);
        }catch (DataAccessException e){
            throw new Excepciones("Hubo un error al crear el tickets " +e.getMessage());
        }

    }

    @Override
    public Tickets editarTicket(Long id, Tickets ticketsAdd) {
        return null;
    }

    @Override
    public void eliminarTicket(Long id) {
        try {
            ticketsEntityRepo.deleteById(id);
        }catch (DataAccessException e){
            throw new Excepciones("Hubo un error al eliminar  el tickets " +e.getMessage());
        }

    }

    @Override
    public Page<Tickets> obtenerTicket(Pageable pageable) {
        return ticketsEntityRepo.findAll(pageable)
                .map(mapperDto::mapEntityTickets);

    }

    @Override
    public Tickets obtenerTicketsId(Long id) {
        return ticketsEntityRepo.findById(id)
                .map(mapperDto::mapEntityTickets)
                .orElseThrow(() -> new Excepciones("No se encontro el ticket "));
    }

    @Override
    public Page<Tickets> obtenerTicketEstatus(Long estatus, Pageable pageable) {
        return ticketsEntityRepo.findByEstatus(estatus,pageable)
                .map(mapperDto::mapEntityTickets);
    }
}
