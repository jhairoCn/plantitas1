package com.plantitas1.plantitas1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import com.plantitas1.plantitas1.repository.UsuarioRepository;
import com.plantitas1.plantitas1.model.Usuario;

public interface UsuarioRepository extends JpaRepository< Usuario, Long>{

}