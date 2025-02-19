package com.example.pid_2025.dal;

import com.example.pid_2025.entities.User; // Importez votre classe User
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    // Trouver un utilisateur par son ID
    Optional<User> findById(long id);

    // Trouver tous les utilisateurs
    List<User> findAll();

    // Trouver des utilisateurs par leur nom de famille
    List<User> findByLastname(String lastname);

    // Trouver des utilisateurs par leur email
    List<User> findAllByEmail(String email);

    // Trouver un utilisateur par son login (nom d'utilisateur)
    Optional<User> findByLogin(String login); // Retourne un Optional<User>
}