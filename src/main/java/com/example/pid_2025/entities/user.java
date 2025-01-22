package com.example.pid_2025.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class user {
    @Id
    private int id ;
    private String login ;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;
}
