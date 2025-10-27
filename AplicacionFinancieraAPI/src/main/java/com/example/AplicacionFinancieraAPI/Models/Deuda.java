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

    public Deuda() {
    }

    public Deuda(String nombre, LocalDate fechaFinal, BigDecimal valorCuota, BigDecimal valorTotal, BigDecimal valorRestante) {
        this.nombre = nombre;
        this.fechaFinal = fechaFinal;
        this.valorCuota = valorCuota;
        this.valorTotal = valorTotal;
        this.valorRestante = valorRestante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public BigDecimal getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(BigDecimal valorCuota) {
        this.valorCuota = valorCuota;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(BigDecimal valorRestante) {
        this.valorRestante = valorRestante;
    }
}
