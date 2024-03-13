package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.AppointmentRepository;
import com.ABCLaboratories.TestRegistrationSystem.Repository.DoctorRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Appointment;
import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImp implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment SaveDoctor(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
