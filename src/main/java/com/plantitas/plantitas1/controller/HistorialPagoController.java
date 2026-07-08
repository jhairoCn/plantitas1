package com.plantitas.plantitas1.controller;

import com.plantitas.plantitas1.model.HistorialPago;
import com.plantitas.plantitas1.service.HistorialPagoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/historial-pagos")
public class HistorialPagoController {
    
    private final HistorialPagoService historialPagoService;

    public HistorialPagoController(HistorialPagoService historialPagoService) {
        this.historialPagoService = historialPagoService;
    }

    @GetMapping
    public List<HistorialPago> getAllPagos() {
        return historialPagoService.getAllPagos();
    }

    @GetMapping("/{id}")
    public HistorialPago getPagoById(@PathVariable Long id) {
        return historialPagoService.getPagoById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<HistorialPago> getPagosByUsuarioId(@PathVariable Long usuarioId) {
        return historialPagoService.getPagosByUsuarioId(usuarioId);
    }

    @PostMapping
    public HistorialPago createPago(@RequestBody HistorialPago pago) {
        return historialPagoService.createPago(pago);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable Long id) {
        historialPagoService.deletePago(id);
    }
}
