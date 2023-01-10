package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Location;

public interface LocationService {
    Location getLocation(Long id);
    List<Location> getAllLocations();
    Location createNewLocation(Location location);
}
