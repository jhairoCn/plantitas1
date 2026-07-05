package com.plantitas1.plantitas1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.plantitas1.plantitas1.service.UsuarioService;   
import java.util.List;
import com.plantitas1.plantitas1.model.Usuario;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("api/usuarios")

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAllUsuario(){
        return usuarioService.getAllUsuario();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }

}