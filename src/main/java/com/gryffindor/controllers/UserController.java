package com.gryffindor.controllers;

import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    private UserService userService;

    public UserController() {}

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @ResponseBody
    public void createUser(@RequestBody User user) {
        System.out.println("UserController: user = " + user);
        userService.createUser(user);
    }

    @GetMapping("/")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    @ResponseBody
    public User getUserById(@PathVariable("user_id")int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/login")
    @ResponseBody
    public User getUserByEmailAndPassword(@RequestBody String[] loginInfo) {
        System.out.println(loginInfo[0]);
        return userService.getUserByEmailAndPassword(loginInfo[0], loginInfo[1]);
    }

    @PutMapping("/")
    @ResponseBody
    public void updateUser(@RequestBody User user) { userService.updateUser(user); }

    @DeleteMapping("/{user_id}")
    @ResponseBody
    public void deleteUser(@PathVariable("user_id")int id) { userService.deleteUser(userService.getUserById(id)); }
}