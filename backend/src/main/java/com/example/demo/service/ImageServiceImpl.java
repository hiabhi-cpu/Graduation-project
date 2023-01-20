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

    @Autowired
    ImageUtilityService imageUtilityService;

    @Override
    public Image getImage(Long id) {
        if(imageRepository.findById(id).isPresent()) {
            Image answer = imageRepository.findById(id).get();
            answer.setImageData(imageUtilityService.deCompressImage(answer.getImageData()));
            return answer;

        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<Image> getAllImages() {
        List<Image> copy = List.copyOf((List<Image>)imageRepository.findAll());
        for(Image image : copy) {
            image.setImageData(imageUtilityService.deCompressImage(image.getImageData()));
        }

        return (List<Image>)copy;
    }

    @Override
    public Image createNewImage(String text, String source, Long id, MultipartFile file) {
        if(locationRepository.findById(id).isPresent()) {
        Location location = locationRepository.findById(id).get();
        Image image = new Image();
            try {
                image.setImageData(imageUtilityService.compressImage(file.getBytes()));
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
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
    }  
}
