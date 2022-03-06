package com.gryffindor.services;

import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public UserService() {}

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        System.out.println("UserService: user = " + user);
        userRepository.save(user);
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
        emailSenderService.sendEmail(user.getEmail(),
                       "This email is to notify you that your account information has been updated recently. If " +
                               "you didn't initiate this action please secure your account. Please do not reply to this" +
                               " message. This email address is not monitored so we are unable to respond to any messages sent to this address. ",
                "Your account information has been updated!");
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}