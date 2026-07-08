package com.plantitas.plantitas1.repository;

import com.plantitas.plantitas1.model.ActividadReciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActividadRecienteRepository extends JpaRepository<ActividadReciente, Long> {
    List<ActividadReciente> findByUsuarioId(Long usuarioId);
}
