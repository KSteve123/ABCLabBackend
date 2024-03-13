package com.ABCLaboratories.TestRegistrationSystem.controller;

import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.model.Test;
import com.ABCLaboratories.TestRegistrationSystem.service.PatientService;
import com.ABCLaboratories.TestRegistrationSystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:3000")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/addTest")
    public String add(@RequestBody Test test){
        testService.SaveTest(test);
        return "New patient added";
    }





    @GetMapping("/getAll")
    public List<Test> getAllTests(){
        return testService.getAllTests();
    }
}
