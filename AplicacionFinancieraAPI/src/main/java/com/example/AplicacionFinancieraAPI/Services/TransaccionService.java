package com.example.AplicacionFinancieraAPI.Services;

import com.example.AplicacionFinancieraAPI.DTOs.TransaccionDto;
import com.example.AplicacionFinancieraAPI.DTOs.TransaccionRequest;
import com.example.AplicacionFinancieraAPI.Exceptions.ResourceNotFoundException;
import com.example.AplicacionFinancieraAPI.Mappers.TransaccionMapper;
import com.example.AplicacionFinancieraAPI.Models.Transaccion;
import com.example.AplicacionFinancieraAPI.Models.Usuario;
import com.example.AplicacionFinancieraAPI.Repositories.ITransaccionRepository;
import com.example.AplicacionFinancieraAPI.Repositories.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransaccionService {

    private final ITransaccionRepository transaccionRepository;
    private final IUsuarioRepository usuarioRepository;

    public TransaccionService(ITransaccionRepository transaccionRepository,
                              IUsuarioRepository usuarioRepository) {
        this.transaccionRepository = transaccionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<TransaccionDto> obtenerTodas() {
        return transaccionRepository.findAll()
                .stream()
                .map(TransaccionMapper::toDto)
                .collect(Collectors.toList());
    }

    public TransaccionDto obtenerPorId(Long id) {
        Transaccion transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transacción no encontrada"));
        return TransaccionMapper.toDto(transaccion);
    }

    public TransaccionDto crear(TransaccionRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Transaccion transaccion = new Transaccion();
        transaccion.setUsuario(usuario);
        transaccion.setMonto(request.getMonto());
        transaccion.setDescripcion(request.getDescripcion());
        transaccion.setFechaTransaccion(request.getFechaTransaccion());
        transaccion.setTipo(request.getTipo());
        transaccion.setMetodoPago(request.getMetodoPago());
        Transaccion transaccionGuardada = transaccionRepository.save(transaccion);
        return TransaccionMapper.toDto(transaccionGuardada);
    }

    public TransaccionDto actualizar(Long id, TransaccionRequest request) {
        Transaccion transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transacción no encontrada"));
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        transaccion.setUsuario(usuario);
        transaccion.setMonto(request.getMonto());
        transaccion.setDescripcion(request.getDescripcion());
        transaccion.setFechaTransaccion(request.getFechaTransaccion());
        transaccion.setTipo(request.getTipo());
        transaccion.setMetodoPago(request.getMetodoPago());
        Transaccion transaccionActualizada = transaccionRepository.save(transaccion);
        return TransaccionMapper.toDto(transaccionActualizada);
    }

    public void eliminar(Long id) {
        Transaccion transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transacción no encontrada"));
        transaccionRepository.delete(transaccion);
    }
}
