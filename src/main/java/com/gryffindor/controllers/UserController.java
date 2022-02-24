package com.gryffindor.controllers;

import com.gryffindor.models.User;
import com.gryffindor.services.UserService;
import com.gryffindor.types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/users")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    public UserController() {}

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUserType(), user.getPhoneNumber());
    }

    @GetMapping("/")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    @ResponseBody
    User getUserById(@PathVariable("user_id")int id) {
        return userService.getUserById(id);
    }
}