/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admininventory.model;

import java.io.Serializable;
import java.sql.Date;



/**
 *
 * @author Dima
 */
public class Employee implements Serializable{
    
    private int userId;
    private String firstName;
    private String secondName;
    private String lastName;
    private String jobPosition;
    private String startDate;
    private String firedDate;

    public Employee() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFiredDate() {
        return firedDate;
    }

    public void setFiredDate(String firedDate) {
        this.firedDate = firedDate;
    }
    
    
    
    
    
    
    
}
