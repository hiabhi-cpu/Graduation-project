package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tag;
import com.example.demo.service.TagService;

@RestController
public class TagController {

    @Autowired 
    TagService tagService;

    @GetMapping("/tag/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable Long id) {
        return new ResponseEntity<>(tagService.getTag(id), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity <List<Tag>> getAllTags() {
        return new ResponseEntity<>(tagService.getAllTags(), HttpStatus.OK);
    }

     @PostMapping("/tag")
     public ResponseEntity<Tag> createNewTag(@RequestParam("name") String name, @RequestParam("color") String color) {
        return new ResponseEntity<>(tagService.createNewTag(name, color), HttpStatus.CREATED);
     }
    
}
