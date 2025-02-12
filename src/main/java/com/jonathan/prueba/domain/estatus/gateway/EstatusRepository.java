package com.jonathan.prueba.domain.estatus.gateway;


import com.jonathan.prueba.domain.estatus.models.Estatus;

public interface EstatusRepository {

    Estatus findByNombre(String nombreEstatus);
}
