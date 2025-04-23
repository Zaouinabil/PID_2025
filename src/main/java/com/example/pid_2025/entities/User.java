package com.example.pid_2025.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
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

    public void addRole(Role role) {
    }


    @Entity
    @Data
    @NoArgsConstructor

    @Table(name = "types")

    public static class Type {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Le type ne peut pas être vide")
        private String type;

        @ManyToMany
        @JoinTable(
                name = "artist_type",
                joinColumns = @JoinColumn(name = "type_id"),
                inverseJoinColumns = @JoinColumn(name = "artist_id"))
        private List<Artist> artists = new ArrayList<>();

        public Type(String type) {
            this.type = type;
        }

        public com.example.pid_2025.entities.Type addArtist(Artist artist) {
            if (!this.artists.contains(artist)) {
                this.artists.add(artist);
                artist.getTypes().add(this);
            }
            return this;
        }

        public com.example.pid_2025.entities.Type removeArtist(Artist artist) {
            if (this.artists.contains(artist)) {
                this.artists.remove(artist);
                artist.getTypes().remove(this);
            }
            return this;
        }

        @Override
        public String toString() {
            return "Type [id=" + id + ", type=" + type + "]";
        }
    }
}
