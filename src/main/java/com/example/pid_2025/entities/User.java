package com.example.pid_2025.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDateTime;


@Entity
public class User {
    @Id
    private int id ;
    @Getter
    private String login ;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;
    private String role;
    private LocalDateTime created_at;

    public User(int id, String login, String password, String firstname, String lastname, String email, String langue, String role, LocalDateTime created_at) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.langue = langue;
        this.role = role;
        this.created_at = created_at;
    }

    public User() { }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getlogin ( String login) { return  login ;}
    public String getRole() {
        return role;
    }
    public int getId() {
        return id;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return login + "(" + firstname + " " + lastname + " - " + role + ")";
    }

}
