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
    private String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setNAme(String Name) {
        this.Name = Name;
    }

    public Doctor(){}
}
