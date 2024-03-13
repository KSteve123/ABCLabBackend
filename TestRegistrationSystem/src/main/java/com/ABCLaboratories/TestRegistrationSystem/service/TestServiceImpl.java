package com.ABCLaboratories.TestRegistrationSystem.service;


import com.ABCLaboratories.TestRegistrationSystem.Repository.TestRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import com.ABCLaboratories.TestRegistrationSystem.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestRepository testRepository;

    @Override
    public Test SaveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAllTests(){
        return testRepository.findAll();

    }
    }

