package com.example.AplicacionFinancieraAPI.Services;

import com.example.AplicacionFinancieraAPI.DTOs.CategoriaDto;
import com.example.AplicacionFinancieraAPI.DTOs.CategoriaRequest;
import com.example.AplicacionFinancieraAPI.Exceptions.ResourceNotFoundException;
import com.example.AplicacionFinancieraAPI.Mappers.CategoriaMapper;
import com.example.AplicacionFinancieraAPI.Models.Categoria;
import com.example.AplicacionFinancieraAPI.Models.Usuario;
import com.example.AplicacionFinancieraAPI.Repositories.ICategoriaRepository;
import com.example.AplicacionFinancieraAPI.Repositories.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final ICategoriaRepository categoriaRepository;
    private final IUsuarioRepository usuarioRepository;

    public CategoriaService(ICategoriaRepository categoriaRepository, IUsuarioRepository usuarioRepository) {
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<CategoriaDto> obtenerTodas() {
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoriaDto obtenerPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        return CategoriaMapper.toDto(categoria);
    }

    public CategoriaDto crear(CategoriaRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Categoria categoria = new Categoria();
        categoria.setUsuario(usuario);
        categoria.setNombre(request.getNombre());
        categoria.setTipo(request.getTipo());
        Categoria categoriaGuardada = categoriaRepository.save(categoria);
        return CategoriaMapper.toDto(categoriaGuardada);
    }

    public CategoriaDto actualizar(Long id, CategoriaRequest request) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        categoria.setUsuario(usuario);
        categoria.setNombre(request.getNombre());
        categoria.setTipo(request.getTipo());
        Categoria categoriaActualizada = categoriaRepository.save(categoria);
        return CategoriaMapper.toDto(categoriaActualizada);
    }

    public void eliminar(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        categoriaRepository.delete(categoria);
    }
}
