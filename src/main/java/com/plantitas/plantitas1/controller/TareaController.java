package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.Tarea;
import com.plantitas.plantitas1.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/tareas")
@Tag(name = "Tareas", description = "Operaciones CRUD para la gestión de tareas de cuidado de plantas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las tareas", description = "Retorna la lista completa de tareas registradas en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida exitosamente")
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tarea por ID", description = "Retorna una tarea específica según su identificador")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Tarea encontrada"),
        @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    public Tarea getTareaById(
            @Parameter(description = "ID de la tarea", required = true) @PathVariable Long id) {
        return tareaService.getTareaById(id);
    }

    @GetMapping("/planta/{plantaId}")
    @Operation(summary = "Obtener tareas por planta", description = "Retorna todas las tareas asociadas a una planta específica")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de tareas de la planta obtenida exitosamente"),
        @ApiResponse(responseCode = "404", description = "Planta no encontrada")
    })
    public List<Tarea> getTareasByPlantaId(
            @Parameter(description = "ID de la planta", required = true) @PathVariable Long plantaId) {
        return tareaService.getTareasByPlantaId(plantaId);
    }

    @PostMapping
    @Operation(summary = "Crear nueva tarea", description = "Registra una nueva tarea de cuidado para una planta")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Tarea creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public Tarea createTarea(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la tarea a crear", required = true)
            @RequestBody Tarea tarea) {
        return tareaService.createTarea(tarea);
    }

    @PutMapping
    @Operation(summary = "Actualizar tarea", description = "Actualiza los datos de una tarea existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Tarea actualizada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    public Tarea updateTarea(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos actualizados de la tarea (debe incluir ID)", required = true)
            @RequestBody Tarea tarea) {
        return tareaService.updateTarea(tarea);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tarea", description = "Elimina una tarea del sistema por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Tarea eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    public void deleteTarea(
            @Parameter(description = "ID de la tarea a eliminar", required = true) @PathVariable Long id) {
        tareaService.deleteTarea(id);
    }
}
