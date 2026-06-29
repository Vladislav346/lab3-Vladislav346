package com.example.lab3.repository;

import com.example.lab3.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Long> {
    List<Hall> findByBuildingId(Long buildingId);
    List<Hall> findByNameContainingIgnoreCase(String name);
}
