package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    ImageUtilityService imageUtilityService;

    @Override
    public Region getRegion(Long id) {
        if(regionRepository.findById(id).isPresent()) {
            Region answer = regionRepository.findById(id).get();
            answer.setImageData(imageUtilityService.deCompressImage(answer.getImageData()));
            return answer;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<Region> getAllRegions() {
        List<Region> copy = List.copyOf((List<Region>)regionRepository.findAll());
        for(Region region : copy) {
            region.setImageData(imageUtilityService.deCompressImage(region.getImageData()));
        }

        return (List<Region>)copy;
    }

    @Override
    public Region createNewRegion(String name, String text, MultipartFile file) {
        Region region = new Region();
        region.setName(name);
        region.setText(text);
        try {
            region.setImageData(imageUtilityService.compressImage(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regionRepository.save(region);
    }

	@Override
	public void deleteRegion(Long id) {
		// TODO Auto-generated method stub
		if(regionRepository.findById(id).isPresent()) {
			regionRepository.deleteById(id);
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
		}
	}

	@Override
	public Region updateRegion(Long id, String name, String text, MultipartFile file) {
		// TODO Auto-generated method stub
		
		if(regionRepository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
		}
		Region region=regionRepository.findById(id).get();
		region.setName(name);
		region.setText(text);
		try {
			region.setImageData(imageUtilityService.compressImage(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return regionRepository.save(region);
	}  
    
    
}

