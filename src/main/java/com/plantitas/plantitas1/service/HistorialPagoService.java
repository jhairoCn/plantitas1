package com.plantitas.plantitas1.service;

import com.plantitas.plantitas1.model.HistorialPago;
import com.plantitas.plantitas1.repository.HistorialPagoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistorialPagoService {
    
    private final HistorialPagoRepository historialPagoRepository;

    public HistorialPagoService(HistorialPagoRepository historialPagoRepository) {
        this.historialPagoRepository = historialPagoRepository;
    }

    public List<HistorialPago> getAllPagos() {
        return historialPagoRepository.findAll();
    }

    public HistorialPago getPagoById(Long id) {
        return historialPagoRepository.findById(id).orElse(null);
    }

    public List<HistorialPago> getPagosByUsuarioId(Long usuarioId) {
        return historialPagoRepository.findByUsuarioId(usuarioId);
    }

    public HistorialPago createPago(HistorialPago pago) {
        return historialPagoRepository.save(pago);
    }

    public void deletePago(Long id) {
        historialPagoRepository.deleteById(id);
    }
}
