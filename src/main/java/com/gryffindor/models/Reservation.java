package com.gryffindor.models;

import java.sql.Timestamp;

public class Reservation {
    private int id;
    private User customer;
    private Timestamp reservationTime;
    private int partySize;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhoneNumber;

    public Reservation() {
    }

    public Reservation(int id, User customer, Timestamp reservationTime, int partySize, String restaurantName, String restaurantAddress, String restaurantPhoneNumber) {
        this.id = id;
        this.customer = customer;
        this.reservationTime = reservationTime;
        this.partySize = partySize;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customer=" + customer +
                ", reservationTime=" + reservationTime +
                ", partySize=" + partySize +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                '}';
    }
}