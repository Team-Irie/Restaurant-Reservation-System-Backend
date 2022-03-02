package com.gryffindor.controllers;

import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController() {}

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @ResponseBody
    public void createUser(@RequestBody User user) { userService.createUser(user); }

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

    @GetMapping("/{email}/{password}")
    @ResponseBody
    public User getUserByEmailAndPassword(@PathVariable("email")String email, @PathVariable("password")String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PutMapping("/{user_id}")
    @ResponseBody
    public void updateUser(@RequestBody User user) { userService.updateUser(user); }

    @DeleteMapping("/{user_id}")
    @ResponseBody
    public void deleteUser(@PathVariable("user_id")int id) { userService.deleteUser(userService.getUserById(id)); }
}