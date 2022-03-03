package com.gryffindor.controllers;

import com.gryffindor.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login")
@CrossOrigin("*")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController() {}
}