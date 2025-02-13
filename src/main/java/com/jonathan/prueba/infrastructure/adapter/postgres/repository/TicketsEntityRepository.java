package com.jonathan.prueba.infrastructure.adapter.postgres.repository;

import com.jonathan.prueba.infrastructure.adapter.postgres.entity.TicketsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsEntityRepository extends JpaRepository<TicketsEntity,Long> {

    Page<TicketsEntity>findAll(Pageable pageable);

    @Query(value = "SELECT * FROM tickets WHERE estatus_id_tickets=:estatudId",nativeQuery = true)
    Page<TicketsEntity>findByEstatus(@Param("estatudId")Long id,  Pageable pageable);
}
