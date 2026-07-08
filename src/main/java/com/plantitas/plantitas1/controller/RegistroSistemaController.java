package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.RegistroSistema;
import com.plantitas.plantitas1.service.RegistroSistemaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/registros")
public class RegistroSistemaController {
    
    private final RegistroSistemaService registroSistemaService;

    public RegistroSistemaController(RegistroSistemaService registroSistemaService) {
        this.registroSistemaService = registroSistemaService;
    }

    @GetMapping
    public List<RegistroSistema> getAllRegistros() {
        return registroSistemaService.getAllRegistros();
    }

    @GetMapping("/{id}")
    public RegistroSistema getRegistroById(@PathVariable Long id) {
        return registroSistemaService.getRegistroById(id);
    }

    @PostMapping
    public RegistroSistema createRegistro(@RequestBody RegistroSistema registro) {
        return registroSistemaService.createRegistro(registro);
    }

    @PutMapping
    public RegistroSistema updateRegistro(@RequestBody RegistroSistema registro) {
        return registroSistemaService.updateRegistro(registro);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistro(@PathVariable Long id) {
        registroSistemaService.deleteRegistro(id);
    }
}
