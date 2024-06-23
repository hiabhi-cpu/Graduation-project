package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;

@RestController
public class RegionController {

    @Autowired 
    RegionService regionService;

    
    @GetMapping("/region/{id}")
    public ResponseEntity<Region> getRegion(@PathVariable Long id) {
        return new ResponseEntity<>(regionService.getRegion(id), HttpStatus.OK);
    }

    @GetMapping("/region")
    public ResponseEntity <List<Region>> getAllRegions() {
        return new ResponseEntity<>(regionService.getAllRegions(), HttpStatus.OK);
    }

     @PostMapping("/region")
     public ResponseEntity<Region> saveRegion(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(regionService.createNewRegion(name, text, file), HttpStatus.CREATED);
     }
     
     @DeleteMapping("/region/{id}")
     public ResponseEntity<HttpStatus> deleteRegoin(@PathVariable("id") Long id){
    	 regionService.deleteRegion(id);
    	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     
     @PutMapping("/region/{id}")
     public ResponseEntity<Region> updateRegion(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("file") MultipartFile file,@PathVariable("id") Long id) {
        return new ResponseEntity<>(regionService.updateRegion(id,name, text, file), HttpStatus.OK);
     }
    
}
