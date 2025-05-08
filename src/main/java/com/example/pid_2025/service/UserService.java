package com.example.pid_2025.service;
import com.example.pid_2025.dal.UserRepository;
import com.example.pid_2025.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        repository.findAll().forEach(users::add);

        return users;
    }
    public User getUser(String id) {
        int indice = Integer.parseInt(id);
        return repository.findById(indice).orElseThrow();
    }
    public void addUser(User user) {
        repository.save(user);
    }

    public void updateUser(String id, User user) {
//        Optional<User> tagedUser = repository.findById(Integer.parseInt(id)) ;
//        if(tagedUser.isPresent()) {
//            tagedUser.get().setFirstname(user.getFirstname());
//            tagedUser.get().setLastname(user.getLastname());
//            tagedUser.get().setEmail(user.getEmail());
//            tagedUser.get().setLogin(user.getLogin());
//            tagedUser.get().setPassword(user.getPassword());
//            repository.save(tagedUser.get());
//        }
//        else
            repository.save(user);
    }
    public void deleteUser(String id) {
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }
}
