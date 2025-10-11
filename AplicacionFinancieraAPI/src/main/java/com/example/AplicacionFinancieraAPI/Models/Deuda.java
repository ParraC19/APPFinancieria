package com.example.AplicacionFinancieraAPI.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "deudas")
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "valor_cuota", precision = 15, scale = 2)
    private BigDecimal valorCuota;

    @Column(name = "valor_total", precision = 15, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "valor_restante", precision = 15, scale = 2)
    private BigDecimal valorRestante;

}
