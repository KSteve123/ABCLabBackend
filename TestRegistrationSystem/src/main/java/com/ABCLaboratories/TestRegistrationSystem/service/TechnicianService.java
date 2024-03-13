package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.model.Technician;


import java.util.List;

public interface TechnicianService {
    public Technician SaveTechnician(Technician technician);
    public List<Technician> getAllTechnicians();
}
