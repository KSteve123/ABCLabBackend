package com.ABCLaboratories.TestRegistrationSystem.controller;

import com.ABCLaboratories.TestRegistrationSystem.model.LoginProcess;
import com.ABCLaboratories.TestRegistrationSystem.model.LoginUser;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("http://localhost:3000")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public String add(@RequestBody Patient patient){
        patientService.SavePatient(patient);
        return "New patient added";
    }
    @PutMapping("/update/{id}")
    public Patient updatePatient(@RequestBody Patient patient, @PathVariable int id){
        return patientService.updatePatient(patient, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
    }
    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable int id){
        return patientService.getPatientById(id);
    }



    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
}
