package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.AppointmentRepository;
import com.ABCLaboratories.TestRegistrationSystem.Repository.DoctorRepository;
import com.ABCLaboratories.TestRegistrationSystem.exception.PatientNotFoundException;
import com.ABCLaboratories.TestRegistrationSystem.model.Appointment;
import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImp implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment SaveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> fetchAppointment(String patientId){
        return appointmentRepository.fetchAppointment(patientId);}

    @Override
    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Sorry, no student found with the Id :" +id));
    }




}
