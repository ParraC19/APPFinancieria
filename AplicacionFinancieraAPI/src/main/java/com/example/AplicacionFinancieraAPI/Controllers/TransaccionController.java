package com.example.AplicacionFinancieraAPI.Controllers;

import com.example.AplicacionFinancieraAPI.DTOs.TransaccionDto;
import com.example.AplicacionFinancieraAPI.DTOs.TransaccionRequest;
import com.example.AplicacionFinancieraAPI.Services.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public ResponseEntity<List<TransaccionDto>> obtenerTransacciones() {
        return ResponseEntity.ok(transaccionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionDto> obtenerTransaccionPorId(@PathVariable Long id) {
        return ResponseEntity.ok(transaccionService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<TransaccionDto> crearTransaccion(@Valid @RequestBody TransaccionRequest request) {
        TransaccionDto transaccionDto = transaccionService.crear(request);
        return ResponseEntity.created(URI.create("/api/transacciones/" + transaccionDto.getId())).body(transaccionDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionDto> actualizarTransaccion(@PathVariable Long id, @Valid @RequestBody TransaccionRequest request) {
        return ResponseEntity.ok(transaccionService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransaccion(@PathVariable Long id) {
        transaccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
