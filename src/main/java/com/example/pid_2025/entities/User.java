package com.example.pid_2025.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    private int id ;
    private String login ;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;
    private String role;
    private LocalDateTime created_at;

    @OneToMany
    private List<Role> roles ;




}
