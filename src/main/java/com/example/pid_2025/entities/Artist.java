package com.example.pid_2025.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @ManyToMany(mappedBy = "artists")
    @JsonIgnore
    private  List<Type> types = new ArrayList<>();


    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public List<Type> getTypes() {
        return types;
    }

    public Artist addType(Type type) {
        if (!this.types.contains(type)) {
            this.types.add(type);
            type.addArtist(this);
        }
        return this;
    }

    public Artist removeType(Type type) {
        if (this.types.contains(type)) {
            this.types.remove(type);
            type.getArtists().remove(this);
        }
        return this;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }


}
