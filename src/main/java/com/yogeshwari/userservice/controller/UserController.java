package com.yogeshwari.userservice.controller;


import com.yogeshwari.userservice.modal.User;
import com.yogeshwari.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user)  {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>( createdUser , HttpStatus.CREATED);
    }

//    @PutMapping
//    public ResponseEntity<User> updateUser(@RequestBody User user , long id) {
//        User updatedUser = userService.updateUser(user , id);
//        return new ResponseEntity<>(updatedUser , HttpStatus.OK);
//    }
//
//    @DeleteMapping
//    public ResponseEntity<User> deleteUser(long id) {
//        User deletedUser = userService.deleteUser(id);
//        return new ResponseEntity<>(deletedUser , HttpStatus.OK);
//    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user , HttpStatus.OK);
    }
}
