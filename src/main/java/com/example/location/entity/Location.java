package com.example.location.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
    
    @Id
    private String locationId;
    
    private String building;
    
    private String floor;
    
    // 기본 생성자
    public Location() {}
    
    // 생성자
    public Location(String locationId, String building, String floor) {
        this.locationId = locationId;
        this.building = building;
        this.floor = floor;
    }
    
    // Getter, Setter
    public String getLocationId() {
        return locationId;
    }
    
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
    
    public String getBuilding() {
        return building;
    }
    
    public void setBuilding(String building) {
        this.building = building;
    }
    
    public String getFloor() {
        return floor;
    }
    
    public void setFloor(String floor) {
        this.floor = floor;
    }
}
