package com.example.pid_2025.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String tag;

    @ManyToMany(mappedBy = "tags")
    private List<Show> shows = new ArrayList<>();

    public List<Show> getShows() {
        return shows;
    }


    @Override
    public String toString() {
        return tag;
    }
}