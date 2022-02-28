package com.gryffindor.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gryffindor.types.ReservationStatus;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    @JsonIgnore
    private User customer;

    @Column(name="reservation_time")
    private Timestamp reservationTime;

    @Column(name="party_size")
    private int partySize;

    @Column(name="restaurant_name")
    private String restaurantName;

    @Column(name="restaurant_address")
    private String restaurantAddress;

    @Column(name="restaurant_phone")
    private String restaurantPhone;

    @Column(name="status")
    private ReservationStatus reservationStatus;

    public Reservation() {}

    public Reservation(int id, User customer, Timestamp reservationTime, int partySize, String restaurantName, String restaurantAddress, String restaurantPhone, ReservationStatus reservationStatus) {
        this.id = id;
        this.customer = customer;
        this.reservationTime = reservationTime;
        this.partySize = partySize;
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
                ", partySize=" + partySize +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhone='" + restaurantPhone + '\'' +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
