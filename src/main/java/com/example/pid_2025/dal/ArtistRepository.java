package com.example.pid_2025.dal;

import com.example.pid_2025.entities.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist,Long> {

    List<Artist> findAll();
    List<Artist> findArtistesByFirstname(String name);



}
