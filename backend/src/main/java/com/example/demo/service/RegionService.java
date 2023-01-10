package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Region;

public interface RegionService {
    Region getRegion(Long id);
    List<Region> getAllRegions();
    Region createNewRegion(String name, String text, MultipartFile file);
}
