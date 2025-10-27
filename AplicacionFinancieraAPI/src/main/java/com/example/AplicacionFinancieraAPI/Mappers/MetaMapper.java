package com.example.AplicacionFinancieraAPI.Mappers;

import com.example.AplicacionFinancieraAPI.DTOs.MetaDto;
import com.example.AplicacionFinancieraAPI.Models.Meta;

public final class MetaMapper {

    private MetaMapper() {
    }

    public static MetaDto toDto(Meta meta) {
        if (meta == null) {
            return null;
        }
        MetaDto dto = new MetaDto();
        dto.setId(meta.getId());
        dto.setUsuarioId(meta.getUsuario() != null ? meta.getUsuario().getId() : null);
        dto.setNombre(meta.getNombre());
        dto.setDescripcion(meta.getDescripcion());
        dto.setMontoObjetivo(meta.getMontoObjetivo());
        dto.setMontoActual(meta.getMontoActual());
        dto.setFechaObjetivo(meta.getFechaObjetivo());
        dto.setEstado(meta.getEstado());
        dto.setFechaCreacion(meta.getFechaCreacion());
        dto.setFechaActualizacion(meta.getFechaActualizacion());
        return dto;
    }
}
