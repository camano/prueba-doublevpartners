package com.jonathan.prueba.infrastructure.adapter.postgres.repositoryImpl;

import com.jonathan.prueba.domain.tickets.gateway.TicketsRepository;
import com.jonathan.prueba.domain.tickets.model.Tickets;
import com.jonathan.prueba.infrastructure.adapter.postgres.entity.TicketsEntity;
import com.jonathan.prueba.infrastructure.adapter.postgres.mapper.MapperDto;
import com.jonathan.prueba.infrastructure.adapter.postgres.repository.TicketsEntityRepository;
import org.springframework.data.domain.Page;
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
        TicketsEntity newTicket = ticketsEntityRepo.save(mapperDto.mapTicketsEntity(ticketsAdd));
        return mapperDto.mapEntityTickets(newTicket);
    }

    @Override
    public Tickets editarTicket(Long id, Tickets ticketsAdd) {
        return null;
    }

    @Override
    public void eliminarTicket(Long id) {
        ticketsEntityRepo.deleteById(id);
    }

    @Override
    public Page<Tickets> obtenerTicket(int pagina, int tamano) {
        return null;
    }

    @Override
    public Tickets obtenerTicketsId(Long id) {
        return ticketsEntityRepo.findById(id)
                .map(mapperDto::mapEntityTickets)
                .orElse(null);
    }
}
