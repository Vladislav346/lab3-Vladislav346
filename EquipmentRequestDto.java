package com.example.lab3.controller;

import com.example.lab3.dto.request.HallRequestDto;
import com.example.lab3.dto.response.HallResponseDto;
import com.example.lab3.service.HallService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {
    private final HallService hallService;
    public HallController(HallService hallService) { this.hallService = hallService; }
    @PostMapping public ResponseEntity<HallResponseDto> create(@Valid @RequestBody HallRequestDto dto) { return ResponseEntity.ok(hallService.create(dto)); }
    @GetMapping public ResponseEntity<List<HallResponseDto>> getAll() { return ResponseEntity.ok(hallService.getAll()); }
    @GetMapping("/{id}") public ResponseEntity<HallResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(hallService.getById(id)); }
    @PutMapping("/{id}") public ResponseEntity<HallResponseDto> update(@PathVariable Long id, @Valid @RequestBody HallRequestDto dto) { return ResponseEntity.ok(hallService.update(id, dto)); }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) { hallService.delete(id); return ResponseEntity.ok("Hall deleted"); }
    @GetMapping("/building/{buildingId}") public ResponseEntity<List<HallResponseDto>> getByBuilding(@PathVariable Long buildingId) { return ResponseEntity.ok(hallService.getByBuilding(buildingId)); }
    @PostMapping("/{id}/building/{buildingId}") public ResponseEntity<HallResponseDto> assignBuilding(@PathVariable Long id, @PathVariable Long buildingId) { return ResponseEntity.ok(hallService.assignBuilding(id, buildingId)); }
    @PostMapping("/{id}/equipment/{equipmentId}") public ResponseEntity<HallResponseDto> addEquipment(@PathVariable Long id, @PathVariable Long equipmentId) { return ResponseEntity.ok(hallService.addEquipment(id, equipmentId)); }
    @DeleteMapping("/{id}/equipment/{equipmentId}") public ResponseEntity<HallResponseDto> removeEquipment(@PathVariable Long id, @PathVariable Long equipmentId) { return ResponseEntity.ok(hallService.removeEquipment(id, equipmentId)); }
}
