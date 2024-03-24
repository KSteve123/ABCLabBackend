package com.ABCLaboratories.TestRegistrationSystem.model;

import jakarta.persistence.*;
@Entity
@Table(name = "tbl_appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "a_pid")
    private String PatientId;
    @Column(name = "a_doctor")
    private String DoctorName;
    @Column(name = "a_test")
    private String TestName;
    @Column(name = "a_technician")
    private String TechnicianID;
    @Column(name = "a_payment")
    private String Payment;
    @Column(name = "date")
    private String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
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

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public String getTechnicianID() {
        return TechnicianID;
    }

    public void setTechnicianID(String technicianID) {
        TechnicianID = technicianID;
    }
}
