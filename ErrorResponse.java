package com.example.lab3.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BuildingRequestDto {
    @NotBlank(message = "Назва будівлі не може бути порожньою")
    @Size(min = 2, max = 100, message = "Назва будівлі має містити від 2 до 100 символів")
    private String name;

    @NotBlank(message = "Місто не може бути порожнім")
    private String city;

    @NotBlank(message = "Адреса не може бути порожньою")
    private String address;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
