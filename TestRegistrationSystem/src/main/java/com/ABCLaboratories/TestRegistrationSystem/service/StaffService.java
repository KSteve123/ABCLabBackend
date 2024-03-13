package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.model.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StaffService {
    public Staff SaveStaff(Staff staff);
    public List<Staff> getAllStaffs();
}
