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

import com.example.demo.entity.Image;
import com.example.demo.entity.Location;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.LocationRepository;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    LocationRepository locationRepository; 

    @Override
    public Image getImage(Long id) {
        if(imageRepository.findById(id).isPresent()) {
            return imageRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<Image> getAllImages() {
        return (List<Image>)imageRepository.findAll();
    }

    @Override
    public Image createNewImage(String text, String source, Long id, MultipartFile file) {
        Location location = locationRepository.findById(id).get();
        Image image = new Image();
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
            if(filename.contains("..")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
            }
            try {
                image.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setText(text);
            image.setSource(source);
            image.setLocation(location);
            location.setImages(image);
            locationRepository.save(location);
            return imageRepository.save(image);
    }  
}
