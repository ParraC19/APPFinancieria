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

    public Meta() {
    }

    public Meta(String nombre, BigDecimal valorTotal, BigDecimal valorActual, BigDecimal valorRestante, LocalDate fechaPlazo) {
        this.nombre = nombre;
        this.valorTotal = valorTotal;
        this.valorActual = valorActual;
        this.valorRestante = valorRestante;
        this.fechaPlazo = fechaPlazo;
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorActual() {
        return valorActual;
    }

    public void setValorActual(BigDecimal valorActual) {
        this.valorActual = valorActual;
    }

    public BigDecimal getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(BigDecimal valorRestante) {
        this.valorRestante = valorRestante;
    }

    public LocalDate getFechaPlazo() {
        return fechaPlazo;
    }

    public void setFechaPlazo(LocalDate fechaPlazo) {
        this.fechaPlazo = fechaPlazo;
    }
}
