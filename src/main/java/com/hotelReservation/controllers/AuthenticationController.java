package com.hotelReservation.controllers;

import com.hotelReservation.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
@CrossOrigin("*")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController() {}
}