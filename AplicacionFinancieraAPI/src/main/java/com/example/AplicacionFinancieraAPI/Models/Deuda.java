package com.example.AplicacionFinancieraAPI.Models;

import com.example.AplicacionFinancieraAPI.Helpers.EstadoDeuda;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "deudas")
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference(value = "usuario-deudas")
    private Usuario usuario;

    @Column(name = "nombre_acreedor", nullable = false, length = 100)
    private String nombreAcreedor;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "monto_original", nullable = false, precision = 12, scale = 2)
    private BigDecimal montoOriginal;

    @Column(name = "monto_restante", nullable = false, precision = 12, scale = 2)
    private BigDecimal montoRestante;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoDeuda estado = EstadoDeuda.ACTIVA;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Deuda() {
    }

    public Deuda(Usuario usuario, String nombreAcreedor, String descripcion, BigDecimal montoOriginal,
                 BigDecimal montoRestante, LocalDate fechaVencimiento, EstadoDeuda estado) {
        this.usuario = usuario;
        this.nombreAcreedor = nombreAcreedor;
        this.descripcion = descripcion;
        this.montoOriginal = montoOriginal;
        this.montoRestante = montoRestante;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreAcreedor() {
        return nombreAcreedor;
    }

    public void setNombreAcreedor(String nombreAcreedor) {
        this.nombreAcreedor = nombreAcreedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(BigDecimal montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public BigDecimal getMontoRestante() {
        return montoRestante;
    }

    public void setMontoRestante(BigDecimal montoRestante) {
        this.montoRestante = montoRestante;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public EstadoDeuda getEstado() {
        return estado;
    }

    public void setEstado(EstadoDeuda estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
}
