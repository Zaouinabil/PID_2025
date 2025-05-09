package com.example.pid_2025.entities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "representations")
public class Representation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    private LocalDateTime when;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = true)
    private Location location;

    @ManyToMany(mappedBy = "representations")
    private List<User> users = new ArrayList<>();

    public Representation() {}

    public Representation(Show show, LocalDateTime when, Location location) {
        this.show = show;
        this.when = when;
        this.location = location;
    }


    public Representation addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
            user.addRepresentation(this);
        }
        return this;
    }

    public Representation removeUser(User user) {
        if (this.users.contains(user)) {
            this.users.remove(user);
            user.getRepresentations().remove(this);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Representation [id=" + id + ", show=" + show + ", when=" + when + ", location=" + location + "]";
    }
}
