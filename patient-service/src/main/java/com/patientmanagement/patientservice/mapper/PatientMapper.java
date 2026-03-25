package com.patientmanagement.patientservice.mapper;

import com.patientmanagement.patientservice.dto.PatientRequestDTO;
import com.patientmanagement.patientservice.dto.PatientResponseDTO;
import com.patientmanagement.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDTO;
    }

    public static Patient toModel(PatientRequestDTO PatientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(PatientRequestDTO.getName());
        patient.setEmail(PatientRequestDTO.getEmail());
        patient.setAddress(PatientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(PatientRequestDTO.getDateOfBirth()));
        patient.setRegistrationDate(LocalDate.now());

        return patient;
    }
}
