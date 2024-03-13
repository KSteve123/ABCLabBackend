package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.DoctorRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImp implements DoctorService{
    @Autowired
    private DoctorRepository Doctorrepository;

    @Override
    public Doctor SaveDoctor(Doctor doctor) {
        return Doctorrepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors(){
        return Doctorrepository.findAll();

    }
}
