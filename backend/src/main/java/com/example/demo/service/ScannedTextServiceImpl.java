package com.example.demo.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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

    @Override
    public ScannedText getScannedText(Long id) {
        if(scannedTextRepository.findById(id).isPresent()) {
            return scannedTextRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<ScannedText> getAllScannedTexts() {
        return (List<ScannedText>)scannedTextRepository.findAll();
    }

    @Override
    public ScannedText createNewScannedText(String text, String source, Long id, MultipartFile file) {
        if(locationRepository.findById(id).isPresent()) {
            Location location = locationRepository.findById(id).get();
            ScannedText scannedText = new ScannedText();
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
                if(filename.contains("..")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
                }
                try {
                    scannedText.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scannedText.setText(text);
                scannedText.setSource(source);
                scannedText.setLocation(location);
                location.setScannedTexts(scannedText);
                locationRepository.save(location);
                return scannedTextRepository.save(scannedText);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }
}
