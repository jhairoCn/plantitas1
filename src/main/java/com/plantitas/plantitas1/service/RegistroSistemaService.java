package com.plantitas.plantitas1.service;

import com.plantitas.plantitas1.model.RegistroSistema;
import com.plantitas.plantitas1.repository.RegistroSistemaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroSistemaService {
    
    private final RegistroSistemaRepository registroSistemaRepository;

    public RegistroSistemaService(RegistroSistemaRepository registroSistemaRepository) {
        this.registroSistemaRepository = registroSistemaRepository;
    }

    public List<RegistroSistema> getAllRegistros() {
        return registroSistemaRepository.findAll();
    }

    public RegistroSistema getRegistroById(Long id) {
        return registroSistemaRepository.findById(id).orElse(null);
    }

    public RegistroSistema createRegistro(RegistroSistema registro) {
        return registroSistemaRepository.save(registro);
    }

    public RegistroSistema updateRegistro(RegistroSistema registro) {
        return registroSistemaRepository.save(registro);
    }

    public void deleteRegistro(Long id) {
        registroSistemaRepository.deleteById(id);
    }
}
