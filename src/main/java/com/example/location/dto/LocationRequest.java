package com.example.location.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LocationRequest {
    
    @NotBlank(message = "위치 ID는 필수입니다")
    @Size(min = 1, max = 50, message = "위치 ID는 1자 이상 50자 이하여야 합니다")
    private String locationId;
    
    @NotBlank(message = "건물명은 필수입니다")
    @Size(min = 1, max = 100, message = "건물명은 1자 이상 100자 이하여야 합니다")
    private String building;
    
    @NotBlank(message = "층 정보는 필수입니다")
    @Size(min = 1, max = 50, message = "층 정보는 1자 이상 50자 이하여야 합니다")
    private String floor;
    
    // 기본 생성자
    public LocationRequest() {}
    
    // 생성자
    public LocationRequest(String locationId, String building, String floor) {
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
