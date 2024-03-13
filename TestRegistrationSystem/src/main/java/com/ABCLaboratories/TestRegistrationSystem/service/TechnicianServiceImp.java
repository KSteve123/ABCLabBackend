package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.TechnicianRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnicianServiceImp implements TechnicianService{
    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public Technician SaveTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }

    @Override
    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

}
