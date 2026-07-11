package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.Rol;
import com.plantitas.plantitas1.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/roles")
@Tag(name = "Roles", description = "Operaciones CRUD para la gestión de roles de usuario")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los roles", description = "Retorna la lista completa de roles disponibles en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista de roles obtenida exitosamente")
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener rol por ID", description = "Retorna un rol específico según su identificador")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Rol encontrado"),
        @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })
    public Rol getRolById(
            @Parameter(description = "ID del rol", required = true) @PathVariable Long id) {
        return rolService.getRolById(id);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo rol", description = "Registra un nuevo rol en el sistema")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Rol creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public Rol createRol(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del rol a crear", required = true)
            @RequestBody Rol rol) {
        return rolService.createRol(rol);
    }

    @PutMapping
    @Operation(summary = "Actualizar rol", description = "Actualiza los datos de un rol existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Rol actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })
    public Rol updateRol(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos actualizados del rol (debe incluir ID)", required = true)
            @RequestBody Rol rol) {
        return rolService.updateRol(rol);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rol", description = "Elimina un rol del sistema por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Rol eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })
    public void deleteRol(
            @Parameter(description = "ID del rol a eliminar", required = true) @PathVariable Long id) {
        rolService.deleteRol(id);
    }
}
