package com.example.pid_2025.service;

import com.example.pid_2025.dal.UserRepository;
import com.example.pid_2025.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return  users;
    }
    public User getUser(long id) {
        return userRepository.findById(id);
    }
    public void addUser(User user) {
        userRepository.save(user);

    }
    public void updateUser(long id, User user) {

        userRepository.save(user);
    }
    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }
}


