package com.example.AplicacionFinancieraAPI.Controllers;

import com.example.AplicacionFinancieraAPI.DTOs.DeudaDto;
import com.example.AplicacionFinancieraAPI.DTOs.DeudaRequest;
import com.example.AplicacionFinancieraAPI.Services.DeudaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/deudas")
public class DeudaController {

    private final DeudaService deudaService;

    public DeudaController(DeudaService deudaService) {
        this.deudaService = deudaService;
    }

    @GetMapping
    public ResponseEntity<List<DeudaDto>> obtenerDeudas() {
        return ResponseEntity.ok(deudaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeudaDto> obtenerDeudaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(deudaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<DeudaDto> crearDeuda(@Valid @RequestBody DeudaRequest request) {
        DeudaDto deudaDto = deudaService.crear(request);
        return ResponseEntity.created(URI.create("/api/deudas/" + deudaDto.getId())).body(deudaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeudaDto> actualizarDeuda(@PathVariable Long id, @Valid @RequestBody DeudaRequest request) {
        return ResponseEntity.ok(deudaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDeuda(@PathVariable Long id) {
        deudaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
