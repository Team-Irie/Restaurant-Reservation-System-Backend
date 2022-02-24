package com.gryffindor.services;

import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.types.UserType;
import com.gryffindor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return userRepository.getAllUsers();
    }

    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}