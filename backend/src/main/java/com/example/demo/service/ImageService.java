package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Image;

public interface ImageService {
    Image getImage(Long id);
    List<Image> getAllImages();
    Image createNewImage(Image image);
}
