package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.Especie;
import com.plantitas.plantitas1.service.EspecieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/especies")
@Tag(name = "Especies", description = "Operaciones CRUD para la gestión de especies de plantas")
public class EspecieController {
    private final EspecieService especieService;

    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las especies", description = "Retorna la lista completa de especies registradas")
    @ApiResponse(responseCode = "200", description = "Lista de especies obtenida exitosamente")
    public List<Especie> getAllEspecies() {
        return especieService.getAllEspecies();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener especie por ID", description = "Retorna una especie específica según su identificador")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Especie encontrada"),
        @ApiResponse(responseCode = "404", description = "Especie no encontrada")
    })
    public Especie getEspecieById(
            @Parameter(description = "ID de la especie", required = true) @PathVariable Long id) {
        return especieService.getEspecieById(id);
    }

    @PostMapping
    @Operation(summary = "Crear nueva especie", description = "Registra una nueva especie en el sistema")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Especie creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public Especie createEspecie(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la especie a crear", required = true)
            @RequestBody Especie especie) {
        return especieService.createEspecie(especie);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar especie", description = "Actualiza los datos de una especie existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Especie actualizada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Especie no encontrada")
    })
    public Especie updateEspecie(
            @Parameter(description = "ID de la especie a actualizar", required = true) @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos actualizados de la especie", required = true)
            @RequestBody Especie especie) {
        especie.setId(id);
        return especieService.updateEspecie(especie);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar especie", description = "Elimina una especie del sistema por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Especie eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Especie no encontrada")
    })
    public void deleteEspecie(
            @Parameter(description = "ID de la especie a eliminar", required = true) @PathVariable Long id) {
        especieService.deleteEspecie(id);
    }
}
