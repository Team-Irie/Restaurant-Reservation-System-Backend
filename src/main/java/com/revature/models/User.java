package com.revature.models;

import com.revature.types.UserRole;

public class User {
    private String first;
    private String last;
    private String email;
    private String password;
    private UserRole role;
    private String phone;

    public User() {
    }

    public User(String first, String last, String email, String password, UserRole role, String phone) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                '}';
    }
}