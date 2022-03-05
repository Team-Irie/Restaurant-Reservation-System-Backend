package com.gryffindor.services;

import java.util.ArrayList;
import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.models.Reservation;
import com.gryffindor.types.ReservationStatus;
import com.gryffindor.repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;
    private EmailSenderService emailSenderService;
    private UserService userService;

    public ReservationService() {}

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        User user = userService.getUserById(reservation.getCustomer());
        emailSenderService.sendEmail(user.getEmail(),
                "This message is to inform you that your reservation has been successfully created.\n" +
                        "Your reservation at: "+reservation.getRestaurantName()+"\n" +
                        "At: "+reservation.getRestaurantAddress()+"\n" +
                        "Is scheduled to be on: "+reservation.getReservationTime()+"\n" +
                        "Party of: "+reservation.getPartySize()+"\n" +
                        "for more information call the number: "+reservation.getRestaurantPhoneNumber()+"\n" +
                        "Please do not reply to this message. This email address is not monitored so we are unable to respond to any messages sent to this address.",
                "Your Reservation Has Been Made!");
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByCustomer(int id) { return reservationRepository.getReservationsByCustomer(id); }

    public List<Reservation> getReservationsByCustomerAndPending(int id) {
        List<Reservation> all = reservationRepository.getReservationsByCustomer(id);
        List<Reservation> pending  = new ArrayList<>();
        for(Reservation item : all){
            if(item.getReservationStatus() == ReservationStatus.PENDING)
                pending.add(item);
        }
        return pending;
    }

    public List<Reservation> getReservationsByCustomerAndServed(int id) {
        List<Reservation> all = reservationRepository.getReservationsByCustomer(id);
        List<Reservation> served  = new ArrayList<>();
        for(Reservation item : all){
            if(item.getReservationStatus() == ReservationStatus.FULFILLED)
                served.add(item);
        }
        return served;
    }

    public Reservation getReservationById(int id) {
        return reservationRepository.getById(id);
    }

    public void approveReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.APPROVED);
        reservationRepository.save(reservation);
    }

    public void denyReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.DENIED);
        reservationRepository.save(reservation);
    }

    public void cancelReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.save(reservation);
    }

    public void fulfillReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.FULFILLED);
        reservationRepository.save(reservation);
    }

    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}