package com.example.AplicacionFinancieraAPI.Mappers;

import com.example.AplicacionFinancieraAPI.DTOs.CategoriaDto;
import com.example.AplicacionFinancieraAPI.Models.Categoria;

public final class CategoriaMapper {

    private CategoriaMapper() {
    }

    public static CategoriaDto toDto(Categoria categoria) {
        if (categoria == null) {
            return null;
        }
        CategoriaDto dto = new CategoriaDto();
        dto.setId(categoria.getId());
        dto.setUsuarioId(categoria.getUsuario() != null ? categoria.getUsuario().getId() : null);
        dto.setNombre(categoria.getNombre());
        dto.setTipo(categoria.getTipo());
        dto.setFechaCreacion(categoria.getFechaCreacion());
        return dto;
    }
}
