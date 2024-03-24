package com.ABCLaboratories.TestRegistrationSystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Entity
@Table(name="tbl_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "p_name")
    private String Name;
    @Column(name = "p_phone")
    private String Phone;
    @NaturalId(mutable = true)
    @Column(name = "p_email")
    private String Email;
    @Column(name = "p_address")
    private String Address;
    @Column(name = "p_password")
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Patient (String email,String password){
        this.Email=email;
        this.Password=password;

    }

    public Patient(int id, String name, String phone, String email, String address, String password) {
        this.id =id;
        Name = name;
        Phone = phone;
        Email = email;
        Address = address;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public Patient(){


    }
    public Patient(int id){
        this.id = id;
    }

    public void EmailLoad(){
        try{
            Connection con = DbConnection.getConnection();


            String mySqlQuery2 =
                    "SELECT * FROM tbl_patient WHERE id ='"+this.getId()+"' ";

            PreparedStatement Stmt2 = con.prepareStatement(mySqlQuery2);
            Stmt2.executeQuery();
            ResultSet r1 = Stmt2.executeQuery();
            while(r1.next()){
                this.setEmail(r1.getString("p_email").toString());


            }


        }
        catch (Exception exception){
            System.out.print("Error" + exception.getMessage());// to identify any backend error
        }

    }


}
