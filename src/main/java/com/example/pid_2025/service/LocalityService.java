package com.example.pid_2025.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.pid_2025.dal.LocalityRepository;
import com.example.pid_2025.entities.Locality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalityService {
    @Autowired
    private LocalityRepository repository;

    public List<Locality> getAll() {
        List<Locality> localities = new ArrayList<>();

        repository.findAll().forEach(localities::add);

        return localities;
    }

    public Locality get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Locality> locality = repository.findById(indice);

        return locality.isPresent() ? locality.get() : null;
    }

    public void add(Locality locality) {
        repository.save(locality);
    }

    public void update(String id, Locality locality) {
        repository.save(locality);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }
}
