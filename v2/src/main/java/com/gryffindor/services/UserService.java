package com.gryffindor.services;

import com.gryffindor.models.User;
import com.gryffindor.repository.UserRepository;
import com.gryffindor.types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository ur;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public User createNewUser(String firstName, String lastName, String email, String password,
                              UserType userType){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        return ur.save(user);
    }

    public List<User> getAll(){
        return ur.findAll();
    }

    public User getById(int id){
        return ur.getById(id);
    }

    public User getByEmailAndPassword(String email, String password){
        return ur.getUserByEmailAndPassword(email,password);
    }

    public void update(User user){
        ur.save(user);
    }

    public void delete(User user){
        ur.delete(user);
    }
}
