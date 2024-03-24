package com.ABCLaboratories.TestRegistrationSystem.controller;

import com.ABCLaboratories.TestRegistrationSystem.model.Appointment;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.model.Test;
import com.ABCLaboratories.TestRegistrationSystem.service.AppointmentService;
import com.ABCLaboratories.TestRegistrationSystem.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("http://localhost:3000")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private EmailSenderService senderService;




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

    @GetMapping("/getAll")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/update/{id}")
    public Appointment updateAppointment(@RequestBody Appointment appointment, @PathVariable int id){
        if (appointment.getPayment().toString().equals("Paid")){
        Patient p1 = new Patient(Integer.parseInt(appointment.getPatientId()));
        p1.EmailLoad();
        Test t1 = new Test(appointment.getTestName().toString());
        t1.TestLoad();
            senderService.sendEmail(p1.getEmail(),"ABC Labs: Appointment ID "+id,"Thank you for the payment. "+t1.getTestName()+" test amount paid is Rs"+t1.getTestAmount());
        }else {}
        return appointmentService.updateAppointment(appointment, id);


    }






    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
    }

}
