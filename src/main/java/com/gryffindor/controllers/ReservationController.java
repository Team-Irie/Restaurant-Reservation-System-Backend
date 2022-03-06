package com.gryffindor.controllers;

import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.services.EmailSenderService;
import com.gryffindor.services.UserService;
import com.gryffindor.models.Reservation;
import com.gryffindor.services.ReservationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationController {


    private UserService userService ;
    private ReservationService reservationService;

    public ReservationController() {}

    @Autowired
    public ReservationController(ReservationService reservationService, UserService userService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @PostMapping("/")
    @ResponseBody
    public void createReservation(@RequestBody Reservation reservation) { reservationService.createReservation(reservation); }

    @GetMapping("/")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/pending")
    public List<Reservation> getPendingReservations() {
        return reservationService.getPendingReservations();
    }

    @GetMapping("/served")
    public List<Reservation> getServedReservations() { return reservationService.getServedReservations(); }

    @GetMapping("/customer/{user_id}")
    public List<Reservation> getReservationsByCustomer(@PathVariable("user_id")int id) {
        return reservationService.getReservationsByCustomer(id);
    }

    @GetMapping("/customer/pending/{user_id}")
    public List<Reservation> getReservationsByCustomerAndPending(@PathVariable("user_id")int id) {
        return reservationService.getReservationsByCustomerAndPending(id);
    }

    @GetMapping("/customer/served/{user_id}")
    public List<Reservation> getReservationsByCustomerAndServed(@PathVariable("user_id")int id) {
        return reservationService.getReservationsByCustomerAndServed(id);
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

    @PutMapping("/")
    @ResponseBody
    public void updateReservation(@RequestBody Reservation reservation) { reservationService.updateReservation(reservation); }

    @DeleteMapping("/{reservation_id}")
    @ResponseBody
    public void deleteReservation(@PathVariable("reservation_id")int id) { reservationService.deleteReservation(reservationService.getReservationById(id)); }
}
