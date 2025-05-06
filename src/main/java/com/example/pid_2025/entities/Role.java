package com.example.pid_2025.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    public Role(String role) {
        this.role = role;
    }

    public Role addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
            user.addRole(this);
        }

        return this;
    }

    public Role removeUser(User user) {
        if (this.users.contains(user)) {
            this.users.remove(user);
            user.getRoles().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + "]";
    }
}
