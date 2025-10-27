package com.example.AplicacionFinancieraAPI.Mappers;

import com.example.AplicacionFinancieraAPI.DTOs.UsuarioDto;
import com.example.AplicacionFinancieraAPI.Models.Usuario;

public final class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static UsuarioDto toDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setCorreo(usuario.getCorreo());
        dto.setFechaCreacion(usuario.getFechaCreacion());
        return dto;
    }
}
