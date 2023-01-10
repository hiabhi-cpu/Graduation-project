package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Place;

public interface PlaceService {
    Place getPlace(Long id);
    List<Place> getAllPlaces();
    Place createNewPlace(Place place);
}
