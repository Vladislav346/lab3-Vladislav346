package com.example.lab3.repository;

import com.example.lab3.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    List<Organizer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String firstName, String lastName, String email);
}
