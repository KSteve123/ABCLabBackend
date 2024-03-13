package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import com.ABCLaboratories.TestRegistrationSystem.model.Test;

import java.util.List;

public interface TestService {
    public Test SaveTest(Test test);

    public List<Test> getAllTests();
}
