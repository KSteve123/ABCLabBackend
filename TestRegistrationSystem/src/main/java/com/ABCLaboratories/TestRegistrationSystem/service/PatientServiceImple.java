package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.PatientRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImple implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient SavePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();

    }
}
