package com.example.lab3.controller;

import com.example.lab3.dto.request.EquipmentRequestDto;
import com.example.lab3.dto.response.EquipmentResponseDto;
import com.example.lab3.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;
    public EquipmentController(EquipmentService equipmentService) { this.equipmentService = equipmentService; }
    @PostMapping public ResponseEntity<EquipmentResponseDto> create(@Valid @RequestBody EquipmentRequestDto dto) { return ResponseEntity.ok(equipmentService.create(dto)); }
    @GetMapping public ResponseEntity<List<EquipmentResponseDto>> getAll() { return ResponseEntity.ok(equipmentService.getAll()); }
    @GetMapping("/{id}") public ResponseEntity<EquipmentResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(equipmentService.getById(id)); }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) { equipmentService.delete(id); return ResponseEntity.ok("Equipment deleted"); }
}
