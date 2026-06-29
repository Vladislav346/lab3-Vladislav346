package com.example.lab3.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OrganizerRequestDto {
    @NotBlank(message = "Ім'я організатора не може бути порожнім")
    @Size(min = 2, max = 50, message = "Ім'я має містити від 2 до 50 символів")
    private String firstName;

    @NotBlank(message = "Прізвище організатора не може бути порожнім")
    @Size(min = 2, max = 50, message = "Прізвище має містити від 2 до 50 символів")
    private String lastName;

    @NotBlank(message = "Email не може бути порожнім")
    @Email(message = "Email має бути коректним")
    private String email;

    @NotBlank(message = "Телефон не може бути порожнім")
    private String phone;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
