package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Location;
import com.example.demo.entity.ScannedText;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ScannedTextRepository;

@Service
public class ScannedTextServiceImpl implements ScannedTextService {
    @Autowired
    ScannedTextRepository scannedTextRepository;

    @Autowired
    LocationRepository locationRepository; 

    @Autowired
    ImageUtilityService imageUtilityService;

    @Override
    public ScannedText getScannedText(Long id) {
        if(scannedTextRepository.findById(id).isPresent()) {
            ScannedText answer = scannedTextRepository.findById(id).get();
            answer.setImageData(imageUtilityService.deCompressImage(answer.getImageData()));
            return answer;

        } else {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
        }
    }

    @Override
    public List<ScannedText> getAllScannedTexts() {
        List<ScannedText> copy = List.copyOf((List<ScannedText>)scannedTextRepository.findAll());
        for(ScannedText image : copy) {
            image.setImageData(imageUtilityService.deCompressImage(image.getImageData()));
        }

        return (List<ScannedText>)copy;
    }

    @Override
    public ScannedText createNewScannedText(String text, String source, Long id, MultipartFile file) {
        if(locationRepository.findById(id).isPresent()) {
        Location location = locationRepository.findById(id).get();
        ScannedText image = new ScannedText();
            try {
                image.setImageData(imageUtilityService.compressImage(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setText(text);
            image.setSource(source);
            image.setLocation(location);
            location.setScannedTexts(image);
            locationRepository.save(location);
            
            return scannedTextRepository.save(image);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
        } 
    }  

    @Override
    public void deleteScannedText(Long id) {
        if(scannedTextRepository.findById(id).isPresent()) {
            scannedTextRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
        }
    
    }










}
