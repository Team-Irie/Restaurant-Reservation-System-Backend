package com.gryffindor.repositories;

import java.util.List;
import com.gryffindor.models.User;
import com.gryffindor.utilities.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByEmail(String email);
}