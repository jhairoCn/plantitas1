package com.plantitas.plantitas1.service;

import com.plantitas.plantitas1.model.Planta;
import com.plantitas.plantitas1.repository.PlantaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlantaService {
    
    private final PlantaRepository plantaRepository;

    public PlantaService(PlantaRepository plantaRepository) {
        this.plantaRepository = plantaRepository;
    }

    public List<Planta> getAllPlantas() {
        return plantaRepository.findAll();
    }

    public Planta getPlantaById(Long id) {
        return plantaRepository.findById(id).orElse(null);
    }

    public List<Planta> getPlantasByUsuarioId(Long usuarioId) {
        return plantaRepository.findByUsuarioId(usuarioId);
    }

    public Planta createPlanta(Planta planta) {
        return plantaRepository.save(planta);
    }

    public Planta updatePlanta(Planta planta) {
        return plantaRepository.save(planta);
    }

    public void deletePlanta(Long id) {
        plantaRepository.deleteById(id);
    }
}
