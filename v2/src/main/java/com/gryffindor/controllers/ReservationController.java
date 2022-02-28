package com.gryffindor.controllers;

import com.gryffindor.models.Reservation;
import com.gryffindor.models.User;
import com.gryffindor.types.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    public ReservationController() {
    }

    @PostMapping("/")
    public String createReservation(@RequestBody Map<String, String> body) {
        return "create reservation";
    }

    @GetMapping("/")
    public String getAllReservations() {
        return "get all reservations";
    }

    @GetMapping("/customer/{user_id}")
    public String getReservationsByCustomer(@PathVariable("user_id")int id) {
        return "get all reservations by uid";
    }

    @GetMapping("/{reservation_status}")
    public String getReservationsByStatus(@PathVariable("reservation_status")ReservationStatus reservationStatus) {
        return "get reservations by status";
    }

    @PutMapping("/approve/{id}")
    public void approveReservation(@PathVariable("id")int id) {
        System.out.println("approving by id");
    }

    @PutMapping("/deny/{id}")
    public void denyReservation(@PathVariable("id")int id) {
        System.out.println("deny by id");
    }

    @PutMapping("/cancel/{id}")
    public void cancelReservation(@PathVariable("id")int id) {
        System.out.println("cancel by id");
    }

    @PutMapping("/fulfill/{id}")
    public void fulfillReservation(@PathVariable("id")int id) {
        System.out.println("fulfill by id");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteReservation(@PathVariable("id")int id) {
        System.out.println("delete by id");
    }
}
