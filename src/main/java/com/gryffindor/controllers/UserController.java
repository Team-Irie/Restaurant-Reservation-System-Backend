package com.gryffindor.controllers;

import com.gryffindor.models.User;
import com.gryffindor.types.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/users")
@CrossOrigin("*")
public class UserController {

    public UserController() {}

    @PostMapping("/")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        User createdUser = user;
        createdUser.setId(1);

        return createdUser;
    }

    @GetMapping("/")
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Dom", "Sieli", "domsieli@gmail.com", "domsieli", UserRole.CUSTOMER, "602-448-9528"));

        return users;
    }
}