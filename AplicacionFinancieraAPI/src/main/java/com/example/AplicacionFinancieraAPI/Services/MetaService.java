package com.example.AplicacionFinancieraAPI.Services;

import com.example.AplicacionFinancieraAPI.DTOs.MetaDto;
import com.example.AplicacionFinancieraAPI.DTOs.MetaRequest;
import com.example.AplicacionFinancieraAPI.Exceptions.ResourceNotFoundException;
import com.example.AplicacionFinancieraAPI.Mappers.MetaMapper;
import com.example.AplicacionFinancieraAPI.Models.Meta;
import com.example.AplicacionFinancieraAPI.Models.Usuario;
import com.example.AplicacionFinancieraAPI.Repositories.IMetaRepository;
import com.example.AplicacionFinancieraAPI.Repositories.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaService {

    private final IMetaRepository metaRepository;
    private final IUsuarioRepository usuarioRepository;

    public MetaService(IMetaRepository metaRepository, IUsuarioRepository usuarioRepository) {
        this.metaRepository = metaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<MetaDto> obtenerTodas() {
        return metaRepository.findAll()
                .stream()
                .map(MetaMapper::toDto)
                .collect(Collectors.toList());
    }

    public MetaDto obtenerPorId(Long id) {
        Meta meta = metaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meta no encontrada"));
        return MetaMapper.toDto(meta);
    }

    public MetaDto crear(MetaRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Meta meta = new Meta();
        meta.setUsuario(usuario);
        meta.setNombre(request.getNombre());
        meta.setDescripcion(request.getDescripcion());
        meta.setMontoObjetivo(request.getMontoObjetivo());
        meta.setMontoActual(request.getMontoActual());
        meta.setFechaObjetivo(request.getFechaObjetivo());
        meta.setEstado(request.getEstado());
        Meta metaGuardada = metaRepository.save(meta);
        return MetaMapper.toDto(metaGuardada);
    }

    public MetaDto actualizar(Long id, MetaRequest request) {
        Meta meta = metaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meta no encontrada"));
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        meta.setUsuario(usuario);
        meta.setNombre(request.getNombre());
        meta.setDescripcion(request.getDescripcion());
        meta.setMontoObjetivo(request.getMontoObjetivo());
        meta.setMontoActual(request.getMontoActual());
        meta.setFechaObjetivo(request.getFechaObjetivo());
        meta.setEstado(request.getEstado());
        Meta metaActualizada = metaRepository.save(meta);
        return MetaMapper.toDto(metaActualizada);
    }

    public void eliminar(Long id) {
        Meta meta = metaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meta no encontrada"));
        metaRepository.delete(meta);
    }
}
