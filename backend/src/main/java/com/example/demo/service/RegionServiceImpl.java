package com.example.demo.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public Region getRegion(Long id) {
        if(regionRepository.findById(id).isPresent()) {
            return regionRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<Region> getAllRegions() {
        return (List<Region>)regionRepository.findAll();
    }

    @Override
    public Region createNewRegion(String name, String text, MultipartFile file) {
        Region region = new Region();
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
            if(filename.contains("..")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
            }
            try {
                region.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            region.setName(name);
            region.setText(text);

            return regionRepository.save(region);
    }  
}

