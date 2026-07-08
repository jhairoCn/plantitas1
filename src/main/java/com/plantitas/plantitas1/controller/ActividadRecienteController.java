package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.ActividadReciente;
import com.plantitas.plantitas1.service.ActividadRecienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/actividades-recientes")
public class ActividadRecienteController {
    
    private final ActividadRecienteService actividadRecienteService;

    public ActividadRecienteController(ActividadRecienteService actividadRecienteService) {
        this.actividadRecienteService = actividadRecienteService;
    }

    @GetMapping
    public List<ActividadReciente> getAllActividades() {
        return actividadRecienteService.getAllActividades();
    }

    @GetMapping("/{id}")
    public ActividadReciente getActividadById(@PathVariable Long id) {
        return actividadRecienteService.getActividadById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ActividadReciente> getActividadesByUsuarioId(@PathVariable Long usuarioId) {
        return actividadRecienteService.getActividadesByUsuarioId(usuarioId);
    }

    @PostMapping
    public ActividadReciente createActividad(@RequestBody ActividadReciente actividad) {
        return actividadRecienteService.createActividad(actividad);
    }

    @DeleteMapping("/{id}")
    public void deleteActividad(@PathVariable Long id) {
        actividadRecienteService.deleteActividad(id);
    }
}
