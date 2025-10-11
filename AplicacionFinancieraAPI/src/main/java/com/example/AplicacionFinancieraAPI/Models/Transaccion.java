package com.example.AplicacionFinancieraAPI.Models;

import com.example.AplicacionFinancieraAPI.Helpers.TipoTransaccion;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 30)
    private TipoTransaccion tipoTransaccion;

    @Column(name = "monto", precision = 15, scale = 2)
    private BigDecimal monto;

    @CreationTimestamp
    @Column(name = "fecha", nullable = false, updatable = false)
    private LocalDate fecha;

    public Transaccion() {
    }

    public Transaccion(String descripcion, TipoTransaccion tipoTransaccion, BigDecimal monto, LocalDate fecha) {
        this.descripcion = descripcion;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
