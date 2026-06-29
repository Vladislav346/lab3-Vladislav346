package com.example.lab3.controller;

import com.example.lab3.dto.request.OrganizerRequestDto;
import com.example.lab3.dto.response.EventResponseDto;
import com.example.lab3.dto.response.OrganizerResponseDto;
import com.example.lab3.service.OrganizerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {
    private final OrganizerService organizerService;
    public OrganizerController(OrganizerService organizerService) { this.organizerService = organizerService; }
    @PostMapping public ResponseEntity<OrganizerResponseDto> create(@Valid @RequestBody OrganizerRequestDto dto) { return ResponseEntity.ok(organizerService.create(dto)); }
    @GetMapping public ResponseEntity<List<OrganizerResponseDto>> getAll() { return ResponseEntity.ok(organizerService.getAll()); }
    @GetMapping("/{id}") public ResponseEntity<OrganizerResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(organizerService.getById(id)); }
    @PutMapping("/{id}") public ResponseEntity<OrganizerResponseDto> update(@PathVariable Long id, @Valid @RequestBody OrganizerRequestDto dto) { return ResponseEntity.ok(organizerService.update(id, dto)); }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) { organizerService.delete(id); return ResponseEntity.ok("Organizer deleted"); }
    @GetMapping("/{id}/events") public ResponseEntity<List<EventResponseDto>> getEvents(@PathVariable Long id) { return ResponseEntity.ok(organizerService.getEvents(id)); }
}
