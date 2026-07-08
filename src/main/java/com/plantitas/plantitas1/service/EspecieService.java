package com.plantitas.plantitas1.service;

import com.plantitas.plantitas1.model.Especie;
import com.plantitas.plantitas1.repository.EspecieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspecieService {
    
    private final EspecieRepository especieRepository;

    public EspecieService(EspecieRepository especieRepository) {
        this.especieRepository = especieRepository;
    }

    public List<Especie> getAllEspecies() {
        return especieRepository.findAll();
    }

    public Especie getEspecieById(Long id) {
        return especieRepository.findById(id).orElse(null);
    }

    public Especie createEspecie(Especie especie) {
        return especieRepository.save(especie);
    }

    public Especie updateEspecie(Especie especie) {
        return especieRepository.save(especie);
    }

    public void deleteEspecie(Long id) {
        especieRepository.deleteById(id);
    }
}
