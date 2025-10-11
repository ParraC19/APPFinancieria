package com.example.AplicacionFinancieraAPI.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "metas")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "valor_total", precision = 15, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "valor_actual", precision = 15, scale = 2)
    private BigDecimal valorActual;

    @Column(name = "valor_restante", precision = 15, scale = 2)
    private BigDecimal valorRestante;

    @Column(name = "fecha_plazo", nullable = false)
    private LocalDate fechaPlazo;

}
