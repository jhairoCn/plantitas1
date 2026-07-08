package com.plantitas.plantitas1.service;

import com.plantitas.plantitas1.model.ActividadReciente;
import com.plantitas.plantitas1.repository.ActividadRecienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActividadRecienteService {
    
    private final ActividadRecienteRepository actividadRecienteRepository;

    public ActividadRecienteService(ActividadRecienteRepository actividadRecienteRepository) {
        this.actividadRecienteRepository = actividadRecienteRepository;
    }

    public List<ActividadReciente> getAllActividades() {
        return actividadRecienteRepository.findAll();
    }

    public ActividadReciente getActividadById(Long id) {
        return actividadRecienteRepository.findById(id).orElse(null);
    }

    public List<ActividadReciente> getActividadesByUsuarioId(Long usuarioId) {
        return actividadRecienteRepository.findByUsuarioId(usuarioId);
    }

    public ActividadReciente createActividad(ActividadReciente actividad) {
        return actividadRecienteRepository.save(actividad);
    }

    public void deleteActividad(Long id) {
        actividadRecienteRepository.deleteById(id);
    }
}
