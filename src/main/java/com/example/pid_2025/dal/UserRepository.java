package com.example.pid_2025.dal;

import com.example.pid_2025.entities.Artiste;
import com.example.pid_2025.entities.user;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface UserRepository extends CrudRepository<user, Long> {

        List<user> findAll();
        List<user> findAllByEmail(String email);

    }

