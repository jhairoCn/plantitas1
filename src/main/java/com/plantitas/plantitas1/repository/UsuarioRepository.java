package com.plantitas1.plantitas1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantitas1.plantitas1.model.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}