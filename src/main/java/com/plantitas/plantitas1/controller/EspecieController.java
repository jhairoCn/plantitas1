package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.Especie;
import com.plantitas.plantitas1.service.EspecieService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/especies")
public class EspecieController {
    private final EspecieService especieService;

    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @GetMapping
    public List<Especie> getAllEspecies() {
        return especieService.getAllEspecies();
    }

    @GetMapping("/{id}")
    public Especie getEspecieById(@PathVariable Long id) {
        return especieService.getEspecieById(id);
    }

    @PostMapping
    public Especie createEspecie(@RequestBody Especie especie) {
        return especieService.createEspecie(especie);
    }

    @PutMapping("/{id}")
    public Especie updateEspecie(@PathVariable Long id, @RequestBody Especie especie) {
        especie.setId(id);
        return especieService.updateEspecie(especie);
    }

    @DeleteMapping("/{id}")
    public void deleteEspecie(@PathVariable Long id) {
        especieService.deleteEspecie(id);
    }
}
