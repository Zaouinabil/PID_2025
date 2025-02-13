package com.example.pid_2025.service;

import com.example.pid_2025.dal.UserRepository;
import com.example.pid_2025.entities.user;
import org.apache.catalina.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public List<user> getAllUsers(){
        List<user> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return  users;
    }
    public user getUser(long id) {
        return userRepository.findById(id);
    }
    public void addUser(user user) {
        userRepository.save(user);

    }
    public void updateUser(long id, user user) {

        userRepository.save(user);
    }
    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }
}


