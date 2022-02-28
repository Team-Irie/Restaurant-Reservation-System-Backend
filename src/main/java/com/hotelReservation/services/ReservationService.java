package com.hotelReservation.services;


import com.hotelReservation.models.Reservation;
import com.hotelReservation.models.User;
import com.hotelReservation.repositories.ReservationRepository;
import com.hotelReservation.types.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService() {}

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(int reservationId, User user, Timestamp reservationTime, int partySize, String restaurantName, String restaurantAddress, String restaurantPhoneNumber, ReservationStatus reservationStatus) {
        Reservation reservation = new Reservation(reservationId, user, reservationTime, partySize, restaurantName, restaurantAddress, restaurantPhoneNumber, reservationStatus);

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByCustomer(User user) {
        return reservationRepository.getReservationsByCustomer(user);
    }

    public List<Reservation> getReservationsByStatus(ReservationStatus reservationStatus) {
        return reservationRepository.getReservationsByStatus(reservationStatus);
    }

    public Reservation getReservationById(int id) {
        return reservationRepository.getById(id);
    }

    public Reservation approveReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.APPROVED);
        return reservationRepository.save(reservation);
    }

    public Reservation denyReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.DENIED);
        return reservationRepository.save(reservation);
    }

    public Reservation cancelReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.CANCELED);
        return reservationRepository.save(reservation);
    }

    public Reservation fulfillReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.FULFILLED);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}