package com.example.pid_2025.dal;

import com.example.pid_2025.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface UserRepository extends CrudRepository<User, Long> {

        User findById(long id);

        List<User> findAll();

        List<User> findBylastename(String lastname);
        List<User> findAllByEmail(String email);

        org.springframework.security.core.userdetails.User findByLogin(String username);
    }

