package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Image;
import com.example.demo.entity.Location;
import com.example.demo.entity.ScannedText;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.RegionRepository;
import com.example.demo.repository.TagRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    ImageUtilityService imageUtilityService;

    @Override
    public Location getLocation(Long id) {
        if(locationRepository.findById(id).isPresent()) {
            Location answer = locationRepository.findById(id).get();
            Set<Image> images = answer.getImages();
            for(Image image : images) {
                image.setImageData(imageUtilityService.deCompressImage(image.getImageData()));
            }
            Set<ScannedText> scannedtexts = answer.getScannedTexts();
            for(ScannedText scannedtext : scannedtexts) {
                scannedtext.setImageData(imageUtilityService.deCompressImage(scannedtext.getImageData()));
            }

            answer.setImages(images);
            answer.setScannedTexts(scannedtexts);
            return answer;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> copy = List.copyOf((List<Location>)locationRepository.findAll());
        for(Location location : copy) {
            Set<Image> images = location.getImages();
            Set<ScannedText> scannedTexts = location.getScannedTexts();
            for(Image image : images) {
                image.setImageData(imageUtilityService.deCompressImage(image.getImageData()));
            }
            for(ScannedText scannedText : scannedTexts) {
                scannedText.setImageData(imageUtilityService.deCompressImage(scannedText.getImageData()));
            }
            location.setImages(images);
            location.setScannedTexts(scannedTexts);
        }

        return (List<Location>)copy;
    }

    @Override
    public List<Location> getAllLocationsBasedOnRegion(Long id) {
        if(regionRepository.findById(id).isPresent()) {
            return (List<Location>)locationRepository.findAllByRegion(regionRepository.findById(id).get());
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public Location createNewLocation(String name, String text, Long id, Long tagId) {
        if(regionRepository.findById(id).isPresent()) {
            Location location = new Location();
            location.setName(name);
            location.setText(text);
            location.setRegion(regionRepository.findById(id).get());
            location.setTag(tagRepository.findById(tagId).get());

            return locationRepository.save(location);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<Location> searchLocation(String keyword) {
        return locationRepository.findByTextContainingIgnoreCase(keyword);
    }

    @Override
    public List<Location> getAllLocationsBasedOnTag(Long id) {
        if(tagRepository.findById(id).isPresent()) {
            return (List<Location>)locationRepository.findAllByTag(tagRepository.findById(id).get());
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }
    
}
