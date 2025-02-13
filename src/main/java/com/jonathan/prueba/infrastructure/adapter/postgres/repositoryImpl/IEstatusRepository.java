package com.jonathan.prueba.infrastructure.adapter.postgres.repositoryImpl;

import com.jonathan.prueba.domain.estatus.gateway.EstatusRepository;
import com.jonathan.prueba.domain.estatus.models.Estatus;
import com.jonathan.prueba.infrastructure.adapter.postgres.mapper.MapperDto;
import com.jonathan.prueba.infrastructure.adapter.postgres.repository.EstatusEntityRespository;
import com.jonathan.prueba.infrastructure.helper.excepciones.Excepciones;
import org.springframework.stereotype.Service;

@Service
public class IEstatusRepository implements EstatusRepository {

    private final EstatusEntityRespository estatusRepository;

    private final MapperDto mapperDto;

    public IEstatusRepository(EstatusEntityRespository estatusRepository, MapperDto mapperDto) {
        this.estatusRepository = estatusRepository;

        this.mapperDto = mapperDto;
    }

    @Override
    public Estatus findByNombre(String nombreEstatus) {
        return estatusRepository.estadoId(nombreEstatus)
                .map(mapperDto::mapEntityEstatus)
                .orElseThrow(() -> new Excepciones("Ese estado no se encuentra solo abierto/cerrado"));
    }
}
