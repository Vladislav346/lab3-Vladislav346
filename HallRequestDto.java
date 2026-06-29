package com.example.lab3.controller;

import com.example.lab3.dto.request.BuildingRequestDto;
import com.example.lab3.dto.response.BuildingResponseDto;
import com.example.lab3.dto.response.EventResponseDto;
import com.example.lab3.dto.response.HallResponseDto;
import com.example.lab3.service.BuildingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {
    private final BuildingService buildingService;
    public BuildingController(BuildingService buildingService) { this.buildingService = buildingService; }
    @PostMapping public ResponseEntity<BuildingResponseDto> create(@Valid @RequestBody BuildingRequestDto dto) { return ResponseEntity.ok(buildingService.create(dto)); }
    @GetMapping public ResponseEntity<List<BuildingResponseDto>> getAll() { return ResponseEntity.ok(buildingService.getAll()); }
    @GetMapping("/{id}") public ResponseEntity<BuildingResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(buildingService.getById(id)); }
    @PutMapping("/{id}") public ResponseEntity<BuildingResponseDto> update(@PathVariable Long id, @Valid @RequestBody BuildingRequestDto dto) { return ResponseEntity.ok(buildingService.update(id, dto)); }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) { buildingService.delete(id); return ResponseEntity.ok("Building deleted"); }
    @GetMapping("/{id}/halls") public ResponseEntity<List<HallResponseDto>> getHalls(@PathVariable Long id) { return ResponseEntity.ok(buildingService.getHalls(id)); }
    @GetMapping("/{id}/events") public ResponseEntity<List<EventResponseDto>> getEvents(@PathVariable Long id) { return ResponseEntity.ok(buildingService.getEvents(id)); }
}
