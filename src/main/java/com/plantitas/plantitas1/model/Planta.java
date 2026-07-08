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
@Table(name = "plantas")
public class Planta {
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_de_usuario", nullable = false)
    private Usuario usuario;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "id_de_especie", length = 50)
    private String idDeEspecie;
    
    @Column(name = "nombre_especie", nullable = false, length = 100)
    private String nombreEspecie;
    
    @Column(name = "frecuencia_de_riego", nullable = false)
    private Integer frecuenciaDeRiego;
    
    @Column(name = "ultimo_riego")
    private LocalDate ultimoRiego;
    
    @Column(name = "proximo_riego")
    private LocalDate proximoRiego;
    
    @Column(length = 50)
    private String estado = "Regada";
    
    @Column(name = "url_de_la_imagen", columnDefinition = "TEXT")
    private String urlDeLaImagen;
    
    @Column(name = "puntuacion_de_salud")
    private Integer puntuacionDeSalud = 100;
    
    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();
    
}
