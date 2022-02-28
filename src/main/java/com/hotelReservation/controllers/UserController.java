package com.hotelReservation.controllers;

import com.hotelReservation.models.User;
import com.hotelReservation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUserType(), user.getPhoneNumber());
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    @ResponseBody
    public User getUserById(@PathVariable("user_id")int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{email}/{password}")
    @ResponseBody
    public User getUserByEmailAndPassword(@PathVariable("email")String email, @PathVariable("password")String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PutMapping("/{user_id}")
    @ResponseBody
    public void updateUser(@PathVariable("user_id")int id) {
        User user = userService.getUserById(id);
        userService.updateUser(user);
    }

    @DeleteMapping("/{user_id}")
    @ResponseBody
    public void deleteUser(@PathVariable("user_id")int id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
    }
}