package com.example.location.controller;

import com.example.location.dto.LocationResponse;
import com.example.location.entity.Location;
import com.example.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationController {
    
    @Autowired
    private LocationRepository locationRepository;
    
    @GetMapping
    public List<LocationResponse> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{location_id}")
    public ResponseEntity<LocationResponse> getLocationById(@PathVariable("location_id") String locationId) {
        Optional<Location> location = locationRepository.findById(locationId);
        if (location.isPresent()) {
            return ResponseEntity.ok(convertToDto(location.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    private LocationResponse convertToDto(Location location) {
        return new LocationResponse(
                location.getLocationId(),
                location.getBuilding(),
                location.getFloor()
        );
    }
}
