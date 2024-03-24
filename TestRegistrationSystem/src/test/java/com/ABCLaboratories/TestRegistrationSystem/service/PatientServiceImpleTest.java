package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.PatientRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientServiceImpleTest {

    @Autowired
    private PatientService patientService;
    @MockBean
    private PatientRepository patientRepository;
    @BeforeEach
    void setup(){
        Patient patient = new Patient(1,"SteveK", "0765484877","stevegame007@gmail.com","123dffgggK","123");
        Mockito.when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
    }
    @Test
    public void TestGetPatientById_Success(){
        String name= "SteveK";
        Patient patientById = patientService.getPatientById(1);
        assertEquals(name,patientById.getName());
    }
}