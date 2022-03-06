package com.gryffindor.models;

import java.sql.Timestamp;
import javax.persistence.*;
import com.gryffindor.types.ReservationStatus;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservationId;

    @Column(name = "customer")
    private int customer;

    @Column(name = "reservation_time")
    private Timestamp reservationTime;

    @Column(name = "party_size")
    private int partySize;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "restaurant_address")
    private String restaurantAddress;

    @Column(name = "restaurant_phone_number")
    private String restaurantPhoneNumber;

    @Column(name = "reservation_status")
    private ReservationStatus reservationStatus;

    @Column(name = "reservation_rating")
    private int reservationRating;

    public Reservation() {
    }

    public Reservation(int reservationId, int customer, Timestamp reservationTime, int partySize, String restaurantName, String restaurantAddress, String restaurantPhoneNumber, ReservationStatus reservationStatus) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.reservationTime = reservationTime;
        this.partySize = partySize;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.reservationStatus = reservationStatus;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPhoneNumber() {
        return restaurantPhoneNumber;
    }

    public void setRestaurantPhoneNumber(String restaurantPhoneNumber) {
        this.restaurantPhoneNumber = restaurantPhoneNumber;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public int getReservationRating() {
        return reservationRating;
    }

    public void setReservationRating(int reservationRating) {
        this.reservationRating = reservationRating;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", customer=" + customer +
                ", reservationTime=" + reservationTime +
                ", partySize=" + partySize +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", reservationStatus=" + reservationStatus +
                ", reservationRating=" + reservationRating +
                '}';
    }
}