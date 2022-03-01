package com.gryffindor.services;

import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.models.Reservation;
import com.gryffindor.repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService() {}

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(Reservation reservation) { reservationRepository.save(reservation); }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByCustomer(User user) { return reservationRepository.getReservationsByCustomer(user); }

    public Reservation getReservationById(int id) {
        return reservationRepository.getById(id);
    }

    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}