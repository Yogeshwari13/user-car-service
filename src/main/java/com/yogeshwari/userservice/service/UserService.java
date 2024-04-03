package com.yogeshwari.userservice.service;

import com.yogeshwari.userservice.modal.User;
import com.yogeshwari.userservice.modal.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {
    @Autowired
    private Vehicle vehicle;
    private static Map<Long, User> userMap = new HashMap<>();
   // private static Map<Long, Appointment> appointmentMap = new HashMap<>();
    private static long userIdCounter = 1;
    private static long appointmentIdCounter = 1;

    public User createUser(User user) {
        User userDetails = User.builder()
                .name(user.getName())
                .id(userIdCounter)
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .vehicle(user.getVehicle())
                .build();

        userMap.put(user.getId(), user);
        return user;
    }

    public User updateUser(@RequestBody User user , long id)  {

        User userDetails = userMap.get(id);

        userDetails = User.builder()
                .name(user.getName())
                .id(user.getId())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .vehicle(user.getVehicle())
                .build();

        return userDetails;
    }


    public User deleteUser(long id) {
        return userMap.remove(id);
    }

    public User getUserById(long id) {
        return userMap.get(id);
    }

//    public Appointment createAppointment(User user, String serviceType, LocalDateTime scheduledDate, String status) {
//        Appointment appointment = new Appointment(appointmentIdCounter++, user, serviceType, scheduledDate, status, LocalDateTime.now(), LocalDateTime.now());
//        appointmentMap.put(appointment.getId(), appointment);
//        return appointment;
//    }
//
//    public List<Appointment> getAppointmentsForUser(User user) {
//        List<Appointment> appointments = new ArrayList<>();
//        for (Appointment appointment : appointmentMap.values()) {
//            if (appointment.getUser().equals(user)) {
//                appointments.add(appointment);
//            }
//        }
//        return appointments;
//    }
}
