package com.plantitas.plantitas1.repository;

import com.plantitas.plantitas1.model.RegistroSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroSistemaRepository extends JpaRepository<RegistroSistema, Long> {
}
