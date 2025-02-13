package com.example.pid_2025.dal;

import com.example.pid_2025.entities.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

    public interface UserRepository extends CrudRepository<user, Long> {

        user findById(long id);

        List<user> findAll();

        List<user> finByLastname(String lastname);
        List<user> findAllByEmail(String email);

        User findByLogin();
    }

