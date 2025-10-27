package com.example.AplicacionFinancieraAPI.DTOs;

import com.example.AplicacionFinancieraAPI.Helpers.MetodoPago;
import com.example.AplicacionFinancieraAPI.Helpers.TipoTransaccion;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransaccionRequest {

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "La categoría es obligatoria")
    private Long categoriaId;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto debe ser mayor a cero")
    private BigDecimal monto;

    private String descripcion;

    @NotNull(message = "La fecha de la transacción es obligatoria")
    private LocalDate fechaTransaccion;

    @NotNull(message = "El tipo es obligatorio")
    private TipoTransaccion tipo;

    @NotNull(message = "El método de pago es obligatorio")
    private MetodoPago metodoPago;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
