package com.plantitas.plantitas1.repository;

import com.plantitas.plantitas1.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByPlantaId(Long plantaId);
}
