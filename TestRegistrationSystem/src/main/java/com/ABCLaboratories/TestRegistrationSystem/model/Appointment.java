package com.ABCLaboratories.TestRegistrationSystem.model;

import jakarta.persistence.*;
@Entity
@Table(name = "tbl_appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "a_email")
    private String PatientEmail;
    @Column(name = "a_doctor")
    private String DoctorName;
    @Column(name = "a_test")
    private String TestName;
    @Column(name = "a_technician")
    private String TechnicianName;
    @Column(name = "a_payment")
    private Float Payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientEmail() {
        return PatientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        PatientEmail = patientEmail;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }

    public String getTechnicianName() {
        return TechnicianName;
    }

    public void setTechnicianName(String technicianName) {
        TechnicianName = technicianName;
    }

    public Float getPayment() {
        return Payment;
    }

    public void setPayment(Float payment) {
        Payment = payment;
    }
}
