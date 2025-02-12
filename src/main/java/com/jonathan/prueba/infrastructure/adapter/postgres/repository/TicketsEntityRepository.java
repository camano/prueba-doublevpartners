package com.jonathan.prueba.infrastructure.adapter.postgres.repository;

import com.jonathan.prueba.infrastructure.adapter.postgres.entity.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsEntityRepository extends JpaRepository<TicketsEntity,Long> {
}
