package com.example.location.controller;

import com.example.location.dto.LocationRequest;
import com.example.location.dto.LocationResponse;
import com.example.location.entity.Location;
import com.example.location.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<LocationResponse> createLocation(@Valid @RequestBody LocationRequest request) {
        try {
            // 중복 체크
            if (locationRepository.existsById(request.getLocationId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            Location location = new Location(
                    request.getLocationId(),
                    request.getBuilding(),
                    request.getFloor()
            );
            
            Location savedLocation = locationRepository.save(location);
            LocationResponse response = convertToDto(savedLocation);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{location_id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("location_id") String locationId) {
        try {
            if (!locationRepository.existsById(locationId)) {
                return ResponseEntity.notFound().build();
            }
            
            locationRepository.deleteById(locationId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
=======
    public ResponseEntity<LocationResponse> createLocation(@RequestBody Location location) {
        Location savedLocation = locationRepository.save(location);
        return ResponseEntity.ok(convertToDto(savedLocation));
>>>>>>> fc58a4c0473186aba3d5894d5e769da9c9843445
    }
    
    private LocationResponse convertToDto(Location location) {
        return new LocationResponse(
                location.getLocationId(),
                location.getBuilding(),
                location.getFloor()
        );
    }
}
