package com.gryffindor.controllers;

import com.gryffindor.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/users")
@CrossOrigin("*")
public class UserController {

    //inject user service here

    public UserController(){ }

    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody User user){
        User created = user;
        created.setId(1);
        return created;
    }

    @GetMapping("/")
    @ResponseBody
    public String getAllUsers() {
        return "getAllUsers";
    }

    @GetMapping("/{user_id}")
    @ResponseBody
    public String getUserById(@PathVariable("user_id")int id) {
        return "get user by id";
    }

    @GetMapping("/{email}/{password}")
    @ResponseBody
    public String getUserByEmailAndPassword(@PathVariable("email")String email, @PathVariable("password")String password) {
        return "get user by email and password";
    }

    @PutMapping("/{user_id}")
    @ResponseBody
    public void updateUser(@PathVariable("user_id")int id) {
        System.out.println("updated user");
    }

    @DeleteMapping("/{user_id}")
    @ResponseBody
    public void deleteUser(@PathVariable("user_id")int id) {
        System.out.println("deleted user");
    }

}
