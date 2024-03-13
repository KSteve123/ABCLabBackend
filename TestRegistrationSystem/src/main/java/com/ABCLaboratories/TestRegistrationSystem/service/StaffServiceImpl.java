package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.PatientRepository;
import com.ABCLaboratories.TestRegistrationSystem.Repository.StaffRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff SaveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }
}
