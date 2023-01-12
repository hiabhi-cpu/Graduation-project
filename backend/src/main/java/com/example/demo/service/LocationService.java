package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Location;

public interface LocationService {
    Location getLocation(Long id);
    List<Location> getAllLocations();
    List<Location> getAllLocationsBasedOnRegion(Long id);
    Location createNewLocation(String name, String text, Long id, Long tagId);
}
