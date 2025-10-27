package com.example.AplicacionFinancieraAPI.Mappers;

import com.example.AplicacionFinancieraAPI.DTOs.TransaccionDto;
import com.example.AplicacionFinancieraAPI.Models.Transaccion;

public final class TransaccionMapper {

    private TransaccionMapper() {
    }

    public static TransaccionDto toDto(Transaccion transaccion) {
        if (transaccion == null) {
            return null;
        }
        TransaccionDto dto = new TransaccionDto();
        dto.setId(transaccion.getId());
        dto.setUsuarioId(transaccion.getUsuario() != null ? transaccion.getUsuario().getId() : null);
        dto.setCategoriaId(transaccion.getCategoria() != null ? transaccion.getCategoria().getId() : null);
        dto.setMonto(transaccion.getMonto());
        dto.setDescripcion(transaccion.getDescripcion());
        dto.setFechaTransaccion(transaccion.getFechaTransaccion());
        dto.setTipo(transaccion.getTipo());
        dto.setMetodoPago(transaccion.getMetodoPago());
        dto.setFechaCreacion(transaccion.getFechaCreacion());
        dto.setFechaActualizacion(transaccion.getFechaActualizacion());
        return dto;
    }
}
