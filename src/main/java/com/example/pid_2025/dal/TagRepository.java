package com.example.pid_2025.dal;
import com.example.pid_2025.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Optional<Tag> findByTag(String tag);
}