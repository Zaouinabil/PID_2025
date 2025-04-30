package com.example.pid_2025.service;

import com.example.pid_2025.dal.LocationRepository;
import com.example.pid_2025.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public Optional<Location> getLocation(long id) {
        return locationRepository.findById(id);
    }

    public Optional<Location> getLocationBySlug(String slug) {
        return locationRepository.findBySlug(slug);
    }

    public List<Location> getLocationsByDesignation(String designation) {
        return locationRepository.findByDesignation(designation);
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    public void deleteLocation(long id) {
        locationRepository.deleteById(id);
    }
}