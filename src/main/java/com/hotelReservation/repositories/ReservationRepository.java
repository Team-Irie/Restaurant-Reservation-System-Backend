package com.hotelReservation.repositories;


import com.hotelReservation.models.Reservation;
import com.hotelReservation.models.User;
import com.hotelReservation.types.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> getReservationsByCustomer(User user);
    List<Reservation> getReservationsByStatus(ReservationStatus reservationStatus);
}