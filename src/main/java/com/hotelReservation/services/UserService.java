package com.hotelReservation.services;


import com.hotelReservation.models.User;
import com.hotelReservation.repositories.UserRepository;
import com.hotelReservation.types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService() {}

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(int userId, String firstName, String lastName, String email, String password, UserType userType, String phoneNumber) {
        User user = new User(userId, firstName, lastName, email, password, userType, phoneNumber);

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    public User melay(int id) {
        User user = userRepository.getById(id);
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        user.setFirstName(firstName + "," + lastName + " " + "Melay");
        return user;

    }
}