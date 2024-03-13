package com.ABCLaboratories.TestRegistrationSystem.controller;

import com.ABCLaboratories.TestRegistrationSystem.model.Technician;
import com.ABCLaboratories.TestRegistrationSystem.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technician")
@CrossOrigin("http://localhost:3000")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @PostMapping("/addTechnician")
    public String add(@RequestBody Technician technician){
        technicianService.SaveTechnician(technician);
        return "New staff added";


    }
    @GetMapping("/getAll")
    public List<Technician> getAllTechnicians(){
        return technicianService.getAllTechnicians();
    }

}
