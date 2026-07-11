package com.plantitas.plantitas1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.plantitas.plantitas1.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import com.plantitas.plantitas1.model.Usuario;

@RestController
@RequestMapping("api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones CRUD para la gestión de usuarios de la plataforma")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Retorna la lista completa de usuarios registrados")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente")
    public List<Usuario> getAllUsuario() {
        return usuarioService.getAllUsuario();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Retorna un usuario específico según su identificador")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public Usuario getUsuarioById(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en el sistema")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public Usuario createUsuario(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del usuario a crear", required = true)
            @RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public void deleteUsuario(
            @Parameter(description = "ID del usuario a eliminar", required = true) @PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}