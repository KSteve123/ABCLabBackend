package com.ABCLaboratories.TestRegistrationSystem.model;

import jakarta.persistence.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Entity
@Table(name = "tbl_test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "te_name")
    private String TestName;
    @Column(name = "te_amount")
    private String TestAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }

    public String getTestAmount() {
        return TestAmount;
    }

    public void setTestAmount(String testAmount) {
        TestAmount = testAmount;
    }

    public Test(String testName){
        this.TestName = testName;
    }

    public Test(){

    }


    public void TestLoad(){
        try{
            Connection con = DbConnection.getConnection();


            String mySqlQuery2 =
                    "SELECT * FROM tbl_test WHERE te_name ='"+this.TestName+"' ";

            PreparedStatement Stmt2 = con.prepareStatement(mySqlQuery2);
            Stmt2.executeQuery();
            ResultSet r1 = Stmt2.executeQuery();
            while(r1.next()){
                this.setTestAmount(r1.getString("te_amount").toString());


            }


        }
        catch (Exception exception){
            System.out.print("Error" + exception.getMessage());// to identify any backend error
        }

    }
}
