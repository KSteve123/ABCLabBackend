package com.ABCLaboratories.TestRegistrationSystem.service;

import com.ABCLaboratories.TestRegistrationSystem.Repository.AppointmentRepository;
import com.ABCLaboratories.TestRegistrationSystem.model.Appointment;
import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import com.ABCLaboratories.TestRegistrationSystem.model.Patient;

import java.util.List;

public interface AppointmentService {

    public Appointment SaveAppointment(Appointment appointment);
    Appointment getAppointmentById(int id);

    public List<Appointment> fetchAppointment(String id);

    public List<Appointment> getAllAppointments();

    Appointment updateAppointment(Appointment appointment, int id);

    Appointment updateReport(Appointment appointment, int id);

    void deleteAppointment(int id);

}
