package com.plantitas.plantitas1.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class Tarea {
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_de_planta", nullable = false)
    private Planta planta;
    
    @Column(name = "tipo_de_tarea", length = 50)
    private String tipoDeTarea = "Riego";
    
    @Column(name = "fecha_programada", nullable = false)
    private LocalDate fechaProgramada;
    
    @Column(length = 50)
    private String estado = "Pendiente";
    
    @Column(name = "completado_en")
    private LocalDateTime completadoEn;
    
    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();
    
}
