package com.jonathan.prueba.infrastructure.adapter.postgres.repository;

import com.jonathan.prueba.infrastructure.adapter.postgres.entity.EstatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstatusEntityRespository extends JpaRepository<EstatusEntity,Long> {

    @Query(value = "SELECT * FROM ESTATUS WHERE nombre_estatus=:nombreEstatus",nativeQuery = true)
    Optional<EstatusEntity> estadoId(@Param("nombreEstatus") String nombreEstatus);
}
