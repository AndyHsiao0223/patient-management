package com.example.patientservice.dto;

import com.example.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Address is required")
    private String address;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Date of birth is required")
    private String dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
