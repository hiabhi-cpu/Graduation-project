package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Image;

public interface ImageService {
    Image getImage(Long id);
    List<Image> getAllImages();
    Image createNewImage(String text, String source, Long id, MultipartFile file);
    void deleteImage(Long id);
}
