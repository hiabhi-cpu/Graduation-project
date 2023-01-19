package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;

@RestController
public class LocationController {

    @Autowired 
    LocationService locationService;

    @GetMapping("/location/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        return new ResponseEntity<>(locationService.getLocation(id), HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity <List<Location>> getAllLocations() {
        return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/location/search")
    public ResponseEntity <List<Location>> searchLocations(@RequestParam("keyword") String keyword) {
        return new ResponseEntity<>(locationService.searchLocation(keyword), HttpStatus.OK);
    }

    @GetMapping("/location/bytag/{id}")
    public ResponseEntity <List<Location>> getAllLocationsFromTag(@PathVariable Long id) {
        return new ResponseEntity<>(locationService.getAllLocationsBasedOnTag(id), HttpStatus.OK);
    }

    @GetMapping("/location/byregion/{id}")
    public ResponseEntity <List<Location>> getAllLocationsFromRegion(@PathVariable Long id) {
        return new ResponseEntity<>(locationService.getAllLocationsBasedOnRegion(id), HttpStatus.OK);
    }

     @PostMapping("/location")
     public ResponseEntity<Location> saveLocation(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("id") Long id, @RequestParam("tagId") Long tagId) {
        return new ResponseEntity<>(locationService.createNewLocation(name, text, id, tagId), HttpStatus.CREATED);
     }
}
