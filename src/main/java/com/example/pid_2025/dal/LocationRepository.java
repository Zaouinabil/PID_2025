package com.example.pid_2025.dal;

import com.example.pid_2025.entities.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {
    
    List<Location> findAll();
    Optional<Location> findById(long id);
    Optional<Location> findBySlug(String slug);
    List<Location> findByDesignation(String designation);
}