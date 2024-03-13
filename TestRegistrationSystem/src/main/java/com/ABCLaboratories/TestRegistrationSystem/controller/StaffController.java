package com.ABCLaboratories.TestRegistrationSystem.controller;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.model.Staff;
import com.ABCLaboratories.TestRegistrationSystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@CrossOrigin("http://localhost:3000")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/add")
    public String add(@RequestBody Staff staff){
        staffService.SaveStaff(staff);
        return "New staff added";


    }
    @GetMapping("/getAll")
    public List<Staff> getAllStaffs(){
        return staffService.getAllStaffs();
    }
}
