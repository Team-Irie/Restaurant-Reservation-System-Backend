package com.gryffindor.controllers;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

import java.sql.Timestamp;
import com.gryffindor.models.User;
import com.gryffindor.utilities.TimeStampParser;
import com.gryffindor.services.ReservationService;
import com.gryffindor.services.UserService;
import com.gryffindor.types.UserType;
import com.gryffindor.models.Reservation;
import com.gryffindor.types.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private UserService userService;
    private ReservationService reservationService;

    public ReservationController() {}

    @Autowired
    public ReservationController(ReservationService reservationService, UserService userService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @PostMapping("/")
    public Reservation createReservation(@RequestBody Map<String, String> body) {
        int userId = Integer.parseInt(body.get("user_id"));
        int partySize = Integer.parseInt(body.get("party_size"));
        String restaurantName = body.get("restaurant_name");
        String restaurantAddress = body.get("restaurant_address");
        String restaurantPhoneNumber = body.get("restaurant_phone_number");
        User user = userService.getUserById(Integer.parseInt(body.get("user_id")));
        Timestamp timestamp = TimeStampParser.parse(body.get("reservation_time"));

        return reservationService.createReservation(userId, user, timestamp, partySize, restaurantName, restaurantAddress, restaurantPhoneNumber, ReservationStatus.PENDING);
    }

    @GetMapping("/")
    @ResponseBody
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/customer/{user_id}")
    public List<Reservation> getReservationsByCustomer(@PathVariable("user_id")int id) {
        User user = userService.getUserById(id);

        return reservationService.getReservationsByCustomer(user);
    }

    @GetMapping("/{reservation_status}")
    public List<Reservation> getReservationsByStatus(@PathVariable("reservation_status")ReservationStatus reservationStatus) {
        return reservationService.getReservationsByStatus(reservationStatus);
    }

    @PutMapping("/approve/{id}")
    public void approveReservation(@PathVariable("reservation_id")int id) {
        Reservation reservation = reservationService.getReservationById(id);
        reservationService.approveReservation(reservation);
    }

    @PutMapping("/deny/{id}")
    public void denyReservation(@PathVariable("reservation_id")int id) {
        Reservation reservation = reservationService.getReservationById(id);
        reservationService.denyReservation(reservation);
    }

    @PutMapping("/cancel/{id}")
    public void cancelReservation(@PathVariable("reservation_id")int id) {
        Reservation reservation = reservationService.getReservationById(id);
        reservationService.cancelReservation(reservation);
    }

    @PutMapping("/fulfill/{id}")
    public void fulfillReservation(@PathVariable("reservation_id")int id) {
        Reservation reservation = reservationService.getReservationById(id);
        reservationService.fulfillReservation(reservation);
    }
}