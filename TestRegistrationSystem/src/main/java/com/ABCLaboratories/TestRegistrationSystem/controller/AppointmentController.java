package com.ABCLaboratories.TestRegistrationSystem.controller;

import com.ABCLaboratories.TestRegistrationSystem.Repository.AppointmentRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Appointment;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.service.AppointmentService;
import com.ABCLaboratories.TestRegistrationSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("http://localhost:3000")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public String add(@RequestBody Appointment appointment){
        appointmentService.SaveAppointment(appointment);
        return "New patient added";
    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointmentById(@PathVariable int id){
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/appointment/all/{patientId}")
    public List<Appointment> getpatientId(@PathVariable String patientId){
        return appointmentService.fetchAppointment(patientId);
    }

}
