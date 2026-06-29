package com.example.lab3.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HallRequestDto {
    @NotBlank(message = "Назва залу не може бути порожньою")
    private String name;

    @NotNull(message = "Місткість залу обов'язкова")
    @Min(value = 1, message = "Місткість залу має бути більше 0")
    private Integer capacity;

    @NotNull(message = "Поверх обов'язковий")
    @Min(value = 0, message = "Поверх не може бути від'ємним")
    private Integer floor;

    private Long buildingId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }
    public Long getBuildingId() { return buildingId; }
    public void setBuildingId(Long buildingId) { this.buildingId = buildingId; }
}
