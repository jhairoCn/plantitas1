package com.plantitas1.plantitas1.service;

import com.plantitas1.plantitas1.repository.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    
}