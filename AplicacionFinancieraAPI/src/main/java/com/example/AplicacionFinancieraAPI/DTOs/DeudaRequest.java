package com.example.AplicacionFinancieraAPI.DTOs;

import com.example.AplicacionFinancieraAPI.Helpers.EstadoDeuda;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DeudaRequest {

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El nombre del acreedor es obligatorio")
    @Size(max = 100, message = "El nombre del acreedor debe tener máximo 100 caracteres")
    private String nombreAcreedor;

    private String descripcion;

    @NotNull(message = "El monto original es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto original debe ser mayor a cero")
    private BigDecimal montoOriginal;

    @NotNull(message = "El monto restante es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El monto restante no puede ser negativo")
    private BigDecimal montoRestante;

    private LocalDate fechaVencimiento;

    @NotNull(message = "El estado es obligatorio")
    private EstadoDeuda estado;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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
}
