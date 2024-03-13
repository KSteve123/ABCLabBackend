package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.model.Patient;

import java.util.List;

public interface PatientService {
    public Patient SavePatient(Patient patient);
    public List<Patient> getAllPatients();
}
