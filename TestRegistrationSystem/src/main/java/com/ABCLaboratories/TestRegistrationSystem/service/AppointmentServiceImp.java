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

    @Override
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();

    }

    @Override
    public Appointment updateAppointment(Appointment appointment, int id) {
        return appointmentRepository.findById(id).map(pt -> {
            pt.setTechnicianID(appointment.getTechnicianID());
            pt.setPayment(appointment.getPayment());
            pt.setPatientId(appointment.getPatientId());
            pt.setTestName(appointment.getTestName());

            return appointmentRepository.save(pt);
        }).orElseThrow(() -> new PatientNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public void deleteAppointment(int id) {
        if (!appointmentRepository.existsById(id)){
            throw new PatientNotFoundException("Sorry, student not found");
        }
        appointmentRepository.deleteById(id);
    }






}
