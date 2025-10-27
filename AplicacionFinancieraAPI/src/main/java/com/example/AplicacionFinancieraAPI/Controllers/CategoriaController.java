package com.example.AplicacionFinancieraAPI.Controllers;

import com.example.AplicacionFinancieraAPI.DTOs.CategoriaDto;
import com.example.AplicacionFinancieraAPI.DTOs.CategoriaRequest;
import com.example.AplicacionFinancieraAPI.Services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> obtenerCategorias() {
        return ResponseEntity.ok(categoriaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> obtenerCategoriaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> crearCategoria(@Valid @RequestBody CategoriaRequest request) {
        CategoriaDto categoriaDto = categoriaService.crear(request);
        return ResponseEntity.created(URI.create("/api/categorias/" + categoriaDto.getId())).body(categoriaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> actualizarCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaRequest request) {
        return ResponseEntity.ok(categoriaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
