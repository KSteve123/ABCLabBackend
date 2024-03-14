package com.ABCLaboratories.TestRegistrationSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "s_name")
    private String UserName;
    @Column(name = "s_password")
    private String Password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Staff(){


    }
}
