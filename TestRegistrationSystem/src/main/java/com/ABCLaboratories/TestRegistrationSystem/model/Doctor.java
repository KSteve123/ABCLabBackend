package com.ABCLaboratories.TestRegistrationSystem.model;

import jakarta.persistence.*;

import javax.naming.Name;
@Entity
@Table(name = "tbl_doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "d_name")
    private String NAme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAme() {
        return NAme;
    }

    public void setNAme(String NAme) {
        this.NAme = NAme;
    }
}
