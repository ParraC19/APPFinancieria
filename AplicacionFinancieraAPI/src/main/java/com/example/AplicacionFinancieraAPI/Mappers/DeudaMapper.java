package com.example.AplicacionFinancieraAPI.Mappers;

import com.example.AplicacionFinancieraAPI.DTOs.DeudaDto;
import com.example.AplicacionFinancieraAPI.Models.Deuda;

public final class DeudaMapper {

    private DeudaMapper() {
    }

    public static DeudaDto toDto(Deuda deuda) {
        if (deuda == null) {
            return null;
        }
        DeudaDto dto = new DeudaDto();
        dto.setId(deuda.getId());
        dto.setUsuarioId(deuda.getUsuario() != null ? deuda.getUsuario().getId() : null);
        dto.setNombreAcreedor(deuda.getNombreAcreedor());
        dto.setDescripcion(deuda.getDescripcion());
        dto.setMontoOriginal(deuda.getMontoOriginal());
        dto.setMontoRestante(deuda.getMontoRestante());
        dto.setFechaVencimiento(deuda.getFechaVencimiento());
        dto.setEstado(deuda.getEstado());
        dto.setFechaCreacion(deuda.getFechaCreacion());
        dto.setFechaActualizacion(deuda.getFechaActualizacion());
        return dto;
    }
}
