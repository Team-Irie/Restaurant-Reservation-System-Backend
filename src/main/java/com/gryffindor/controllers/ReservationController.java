package com.gryffindor.controllers;

import java.sql.Timestamp;
import com.gryffindor.models.User;
import com.gryffindor.types.UserRole;
import com.gryffindor.models.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/reservations")
@CrossOrigin("*")
public class ReservationController {

    public ReservationController() {}

    @PostMapping("/")
    @ResponseBody

    public Reservation createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservation;
        createdReservation.setId(1);

        return createdReservation;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        User user = new User(1, "Dom", "Sieli", "domsieli@gmail.com", "domsieli", UserRole.CUSTOMER, "602-448-9528");
        reservations.add(new Reservation(1, user, Timestamp.valueOf(LocalDateTime.now()), 1, "green", "Phoenix", "602-867-5309"));

        return reservations;
    }
}