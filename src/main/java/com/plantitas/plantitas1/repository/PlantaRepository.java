package com.plantitas.plantitas1.repository;

import com.plantitas.plantitas1.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
    List<Planta> findByUsuarioId(Long usuarioId);
}
