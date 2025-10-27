package com.example.AplicacionFinancieraAPI.Services;

import com.example.AplicacionFinancieraAPI.DTOs.DeudaDto;
import com.example.AplicacionFinancieraAPI.DTOs.DeudaRequest;
import com.example.AplicacionFinancieraAPI.Exceptions.ResourceNotFoundException;
import com.example.AplicacionFinancieraAPI.Mappers.DeudaMapper;
import com.example.AplicacionFinancieraAPI.Models.Deuda;
import com.example.AplicacionFinancieraAPI.Models.Usuario;
import com.example.AplicacionFinancieraAPI.Repositories.IDeudaRepository;
import com.example.AplicacionFinancieraAPI.Repositories.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeudaService {

    private final IDeudaRepository deudaRepository;
    private final IUsuarioRepository usuarioRepository;

    public DeudaService(IDeudaRepository deudaRepository, IUsuarioRepository usuarioRepository) {
        this.deudaRepository = deudaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<DeudaDto> obtenerTodas() {
        return deudaRepository.findAll()
                .stream()
                .map(DeudaMapper::toDto)
                .collect(Collectors.toList());
    }

    public DeudaDto obtenerPorId(Long id) {
        Deuda deuda = deudaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deuda no encontrada"));
        return DeudaMapper.toDto(deuda);
    }

    public DeudaDto crear(DeudaRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Deuda deuda = new Deuda();
        deuda.setUsuario(usuario);
        deuda.setNombreAcreedor(request.getNombreAcreedor());
        deuda.setDescripcion(request.getDescripcion());
        deuda.setMontoOriginal(request.getMontoOriginal());
        deuda.setMontoRestante(request.getMontoRestante());
        deuda.setFechaVencimiento(request.getFechaVencimiento());
        deuda.setEstado(request.getEstado());
        Deuda deudaGuardada = deudaRepository.save(deuda);
        return DeudaMapper.toDto(deudaGuardada);
    }

    public DeudaDto actualizar(Long id, DeudaRequest request) {
        Deuda deuda = deudaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deuda no encontrada"));
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        deuda.setUsuario(usuario);
        deuda.setNombreAcreedor(request.getNombreAcreedor());
        deuda.setDescripcion(request.getDescripcion());
        deuda.setMontoOriginal(request.getMontoOriginal());
        deuda.setMontoRestante(request.getMontoRestante());
        deuda.setFechaVencimiento(request.getFechaVencimiento());
        deuda.setEstado(request.getEstado());
        Deuda deudaActualizada = deudaRepository.save(deuda);
        return DeudaMapper.toDto(deudaActualizada);
    }

    public void eliminar(Long id) {
        Deuda deuda = deudaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deuda no encontrada"));
        deudaRepository.delete(deuda);
    }
}
