package com.example.lab3.controller;

import com.example.lab3.dto.request.EventRequestDto;
import com.example.lab3.dto.response.EventResponseDto;
import com.example.lab3.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService) { this.eventService = eventService; }
    @PostMapping public ResponseEntity<EventResponseDto> create(@Valid @RequestBody EventRequestDto dto) { return ResponseEntity.ok(eventService.create(dto)); }
    @GetMapping public ResponseEntity<List<EventResponseDto>> getAll() { return ResponseEntity.ok(eventService.getAll()); }
    @GetMapping("/{id}") public ResponseEntity<EventResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(eventService.getById(id)); }
    @PutMapping("/{id}") public ResponseEntity<EventResponseDto> update(@PathVariable Long id, @Valid @RequestBody EventRequestDto dto) { return ResponseEntity.ok(eventService.update(id, dto)); }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) { eventService.delete(id); return ResponseEntity.ok("Event cancelled"); }
    @GetMapping("/active") public ResponseEntity<List<EventResponseDto>> getActive() { return ResponseEntity.ok(eventService.getActive()); }
    @PostMapping("/{eventId}/organizer/{organizerId}") public ResponseEntity<EventResponseDto> assignOrganizer(@PathVariable Long eventId, @PathVariable Long organizerId) { return ResponseEntity.ok(eventService.assignOrganizer(eventId, organizerId)); }
    @PostMapping("/{eventId}/hall/{hallId}") public ResponseEntity<EventResponseDto> assignHall(@PathVariable Long eventId, @PathVariable Long hallId) { return ResponseEntity.ok(eventService.assignHall(eventId, hallId)); }
    @PostMapping("/{eventId}/building/{buildingId}") public ResponseEntity<EventResponseDto> assignBuilding(@PathVariable Long eventId, @PathVariable Long buildingId) { return ResponseEntity.ok(eventService.assignBuilding(eventId, buildingId)); }
}
