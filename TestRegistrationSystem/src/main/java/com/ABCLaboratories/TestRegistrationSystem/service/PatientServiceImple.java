package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.PatientRepository;
import com.ABCLaboratories.TestRegistrationSystem.exception.PatientNotFoundException;
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
    @Override
    public Patient updatePatient(Patient patient, int id) {
        return patientRepository.findById(id).map(pt -> {
            pt.setName(patient.getName());
            pt.setEmail(patient.getEmail());
            pt.setAddress(patient.getAddress());
            pt.setPhone(patient.getPhone());
            return patientRepository.save(pt);
        }).orElseThrow(() -> new PatientNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Sorry, no student found with the Id :" +id));
    }


    @Override
    public void deletePatient(int id) {
        if (!patientRepository.existsById(id)){
            throw new PatientNotFoundException("Sorry, student not found");
        }
        patientRepository.deleteById(id);
    }
    /*private boolean patientAlreadyExists(String email) {
        return patientRepository.findByEmail(email).isPresent();
    } */
}
