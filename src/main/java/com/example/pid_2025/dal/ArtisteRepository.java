package com.example.pid_2025.dal;

import com.example.pid_2025.entities.Artiste;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtisteRepository extends CrudRepository<Artiste,Long> {

    List<Artiste> findAll();
    List<Artiste> findArtistesByFirstname( String name);

}
