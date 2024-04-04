package com.yogeshwari.userservice.modal;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;

    private Vehicle vehicle;


    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User(){

    }
    public User(long id, String username, String password, String email, String name, String phoneNumber, String role, Vehicle vehicle) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.vehicle = vehicle;
    }
}
