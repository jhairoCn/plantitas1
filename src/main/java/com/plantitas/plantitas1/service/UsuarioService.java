package com.plantitas1.plantitas1.service;

import com.plantitas1.plantitas1.model.Usuario; 
import com.plantitas1.plantitas1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List; 

@Service 
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);    
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
        }
}