//package com.gryffindor.services;
//
//import java.util.List;
//import java.sql.Timestamp;
//import com.gryffindor.models.User;
//import com.gryffindor.models.Reservation;
//import com.gryffindor.types.ReservationStatus;
//import com.gryffindor.repositories.ReservationRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//public class ReservationService {
//    private ReservationRepository reservationRepository;
//
//    public ReservationService() {}
//
//    @Autowired
//    public ReservationService(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }
//
//    public Reservation createReservation(int reservationId, User user, Timestamp reservationTime, int partySize, String restaurantName, String restaurantAddress, String restaurantPhoneNumber, ReservationStatus reservationStatus) {
//        Reservation reservation = new Reservation(reservationId, user, reservationTime, partySize, restaurantName, restaurantAddress, restaurantPhoneNumber, reservationStatus);
//
//        return reservationRepository.save(reservation);
//    }
//
//    public List<Reservation> getAllReservations() {
//        return reservationRepository.findAll();
//    }
//
//    public List<Reservation> getReservationsByCustomer(User user) {
//        return reservationRepository.getReservationsByCustomer(user);
//    }
//
//    public List<Reservation> getReservationsByStatus(ReservationStatus reservationStatus) {
//        return reservationRepository.getReservationsByStatus(reservationStatus);
//    }
//
//    public Reservation getReservationById(int id) {
//        return reservationRepository.getById(id);
//    }
//
//    public void approveReservation(Reservation reservation) {
//        reservation.setReservationStatus(ReservationStatus.APPROVED);
//        reservationRepository.save(reservation);
//    }
//
//    public void denyReservation(Reservation reservation) {
//        reservation.setReservationStatus(ReservationStatus.DENIED);
//        reservationRepository.save(reservation);
//    }
//
//    public void cancelReservation(Reservation reservation) {
//        reservation.setReservationStatus(ReservationStatus.CANCELED);
//        reservationRepository.save(reservation);
//    }
//
//    public void fulfillReservation(Reservation reservation) {
//        reservation.setReservationStatus(ReservationStatus.FULFILLED);
//        reservationRepository.save(reservation);
//    }
//
//    public void deleteReservation(Reservation reservation) {
//        reservationRepository.delete(reservation);
//    }
//}