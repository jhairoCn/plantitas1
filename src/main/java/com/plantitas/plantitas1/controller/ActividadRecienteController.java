package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.ActividadReciente;
import com.plantitas.plantitas1.service.ActividadRecienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/actividades-recientes")
@Tag(name = "Actividades Recientes", description = "Operaciones para la gestión del historial de actividades recientes de usuarios")
public class ActividadRecienteController {

    private final ActividadRecienteService actividadRecienteService;

    public ActividadRecienteController(ActividadRecienteService actividadRecienteService) {
        this.actividadRecienteService = actividadRecienteService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las actividades", description = "Retorna la lista completa de actividades recientes registradas")
    @ApiResponse(responseCode = "200", description = "Lista de actividades obtenida exitosamente")
    public List<ActividadReciente> getAllActividades() {
        return actividadRecienteService.getAllActividades();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener actividad por ID", description = "Retorna una actividad reciente específica según su identificador")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Actividad encontrada"),
        @ApiResponse(responseCode = "404", description = "Actividad no encontrada")
    })
    public ActividadReciente getActividadById(
            @Parameter(description = "ID de la actividad", required = true) @PathVariable Long id) {
        return actividadRecienteService.getActividadById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Obtener actividades por usuario", description = "Retorna todas las actividades recientes de un usuario específico")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de actividades del usuario obtenida exitosamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public List<ActividadReciente> getActividadesByUsuarioId(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Long usuarioId) {
        return actividadRecienteService.getActividadesByUsuarioId(usuarioId);
    }

    @PostMapping
    @Operation(summary = "Registrar actividad reciente", description = "Crea un nuevo registro de actividad reciente para un usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Actividad registrada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ActividadReciente createActividad(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la actividad a registrar", required = true)
            @RequestBody ActividadReciente actividad) {
        return actividadRecienteService.createActividad(actividad);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar actividad reciente", description = "Elimina un registro de actividad reciente por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Actividad eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Actividad no encontrada")
    })
    public void deleteActividad(
            @Parameter(description = "ID de la actividad a eliminar", required = true) @PathVariable Long id) {
        actividadRecienteService.deleteActividad(id);
    }
}
