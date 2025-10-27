package com.example.AplicacionFinancieraAPI.Controllers;

import com.example.AplicacionFinancieraAPI.DTOs.MetaDto;
import com.example.AplicacionFinancieraAPI.DTOs.MetaRequest;
import com.example.AplicacionFinancieraAPI.Services.MetaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    private final MetaService metaService;

    public MetaController(MetaService metaService) {
        this.metaService = metaService;
    }

    @GetMapping
    public ResponseEntity<List<MetaDto>> obtenerMetas() {
        return ResponseEntity.ok(metaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaDto> obtenerMetaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(metaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<MetaDto> crearMeta(@Valid @RequestBody MetaRequest request) {
        MetaDto metaDto = metaService.crear(request);
        return ResponseEntity.created(URI.create("/api/metas/" + metaDto.getId())).body(metaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetaDto> actualizarMeta(@PathVariable Long id, @Valid @RequestBody MetaRequest request) {
        return ResponseEntity.ok(metaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMeta(@PathVariable Long id) {
        metaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
