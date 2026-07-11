package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.Planta;
import com.plantitas.plantitas1.service.PlantaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/plantas")
@Tag(name = "Plantas", description = "Operaciones CRUD para la gestión de plantas de usuarios")
public class PlantaController {

    private final PlantaService plantaService;

    public PlantaController(PlantaService plantaService) {
        this.plantaService = plantaService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las plantas", description = "Retorna la lista completa de plantas registradas en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista de plantas obtenida exitosamente")
    public List<Planta> getAllPlantas() {
        return plantaService.getAllPlantas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener planta por ID", description = "Retorna una planta específica según su identificador")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Planta encontrada"),
        @ApiResponse(responseCode = "404", description = "Planta no encontrada")
    })
    public Planta getPlantaById(
            @Parameter(description = "ID de la planta", required = true) @PathVariable Long id) {
        return plantaService.getPlantaById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Obtener plantas por usuario", description = "Retorna todas las plantas pertenecientes a un usuario específico")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de plantas del usuario obtenida exitosamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public List<Planta> getPlantasByUsuarioId(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Long usuarioId) {
        return plantaService.getPlantasByUsuarioId(usuarioId);
    }

    @PostMapping
    @Operation(summary = "Crear nueva planta", description = "Registra una nueva planta asociada a un usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Planta creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public Planta createPlanta(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la planta a crear", required = true)
            @RequestBody Planta planta) {
        return plantaService.createPlanta(planta);
    }

    @PutMapping
    @Operation(summary = "Actualizar planta", description = "Actualiza los datos de una planta existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Planta actualizada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Planta no encontrada")
    })
    public Planta updatePlanta(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos actualizados de la planta (debe incluir ID)", required = true)
            @RequestBody Planta planta) {
        return plantaService.updatePlanta(planta);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar planta", description = "Elimina una planta del sistema por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Planta eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Planta no encontrada")
    })
    public void deletePlanta(
            @Parameter(description = "ID de la planta a eliminar", required = true) @PathVariable Long id) {
        plantaService.deletePlanta(id);
    }
}
