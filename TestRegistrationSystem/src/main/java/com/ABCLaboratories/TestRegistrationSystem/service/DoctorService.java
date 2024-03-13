package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;

import java.util.List;

public interface DoctorService {
    public Doctor SaveDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();
}
