package com.ABCLaboratories.TestRegistrationSystem.model;

import jakarta.persistence.*;
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
}
