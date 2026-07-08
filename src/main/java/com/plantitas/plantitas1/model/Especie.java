package com.plantitas.plantitas1.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "especies")
public class Especie {
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String nombre;
    
    @Column(name = "nombre_cientifico", length = 150)
    private String nombreCientifico;
    
    @Column(name = "frecuencia_de_riego", nullable = false)
    private Integer frecuenciaDeRiego;
    
    @Column(name = "luz_recomendada", length = 100)
    private String luzRecomendada;
    
    @Column(name = "temperatura_ideal", length = 50)
    private String temperaturaIdeal;
    
}
