package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.Tarea;
import com.plantitas.plantitas1.service.TareaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/tareas")
public class TareaController {
    
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    public Tarea getTareaById(@PathVariable Long id) {
        return tareaService.getTareaById(id);
    }

    @GetMapping("/planta/{plantaId}")
    public List<Tarea> getTareasByPlantaId(@PathVariable Long plantaId) {
        return tareaService.getTareasByPlantaId(plantaId);
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaService.createTarea(tarea);
    }

    @PutMapping
    public Tarea updateTarea(@RequestBody Tarea tarea) {
        return tareaService.updateTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
    }
}
