package com.gryffindor.models;

import com.gryffindor.types.ReservationStatus;

import java.sql.Timestamp;

public class Reservation {
    private int id;
    private User customer;
    private Timestamp reservationTime;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
    private ReservationStatus reservationStatus;

    public Reservation() {}

    public Reservation(int id, User customer, Timestamp reservationTime, String restaurantName,
                       String restaurantAddress, String restaurantPhone, ReservationStatus reservationStatus) {
        this.id = id;
        this.customer = customer;
        this.reservationTime = reservationTime;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
        this.reservationStatus = reservationStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
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

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customer=" + customer +
                ", reservationTime=" + reservationTime +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhone='" + restaurantPhone + '\'' +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
