package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.Planta;
import com.plantitas.plantitas1.service.PlantaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/plantas")
public class PlantaController {
    
    private final PlantaService plantaService;

    public PlantaController(PlantaService plantaService) {
        this.plantaService = plantaService;
    }

    @GetMapping
    public List<Planta> getAllPlantas() {
        return plantaService.getAllPlantas();
    }

    @GetMapping("/{id}")
    public Planta getPlantaById(@PathVariable Long id) {
        return plantaService.getPlantaById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Planta> getPlantasByUsuarioId(@PathVariable Long usuarioId) {
        return plantaService.getPlantasByUsuarioId(usuarioId);
    }

    @PostMapping
    public Planta createPlanta(@RequestBody Planta planta) {
        return plantaService.createPlanta(planta);
    }

    @PutMapping
    public Planta updatePlanta(@RequestBody Planta planta) {
        return plantaService.updatePlanta(planta);
    }

    @DeleteMapping("/{id}")
    public void deletePlanta(@PathVariable Long id) {
        plantaService.deletePlanta(id);
    }
}
