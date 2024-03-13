package com.ABCLaboratories.TestRegistrationSystem.controller;

import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.service.DoctorService;
import com.ABCLaboratories.TestRegistrationSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("http://localhost:3000")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor")
    public String add(@RequestBody Doctor doctor){
        doctorService.SaveDoctor(doctor);
        return "New patient added";
    }





    @GetMapping("/getAll")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
}
