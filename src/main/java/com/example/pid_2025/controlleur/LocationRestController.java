package com.example.pid_2025.controlleur;
import com.example.pid_2025.entities.Location;
import com.example.pid_2025.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationRestController {

    @Autowired
    private LocationService locationService;

    @GetMapping("")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        return locationService.getLocation(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<Location> getLocationBySlug(@PathVariable String slug) {
        return locationService.getLocationBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/designation/{designation}")
    public List<Location> getLocationsByDesignation(@PathVariable String designation) {
        return locationService.getLocationsByDesignation(designation);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Location createLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        return locationService.getLocation(id)
                .map(existingLocation -> {
                    // Update the fields of the existing location
                    existingLocation.setDesignation(location.getDesignation());
                    existingLocation.setAddress(location.getAddress());
                    existingLocation.setWebsite(location.getWebsite());
                    existingLocation.setPhone(location.getPhone());
                    if (location.getLocality() != null) {
                        existingLocation.setLocality(location.getLocality());
                    }
                    return ResponseEntity.ok(locationService.updateLocation(existingLocation));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        return locationService.getLocation(id)
                .map(location -> {
                    locationService.deleteLocation(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
