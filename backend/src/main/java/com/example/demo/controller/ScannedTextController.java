package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ScannedText;
import com.example.demo.service.ScannedTextService;

@RestController
public class ScannedTextController {
    @Autowired 
    ScannedTextService scannedTextService;

    @GetMapping("/scannedtext/{id}")
    public ResponseEntity<ScannedText> getScannedtext(@PathVariable Long id) {
        return new ResponseEntity<>(scannedTextService.getScannedText(id), HttpStatus.OK);
    }

    @GetMapping("/scannedtext")
    public ResponseEntity <List<ScannedText>> getAllScannedTexts() {
        return new ResponseEntity<>(scannedTextService.getAllScannedTexts(), HttpStatus.OK);
    }

     @PostMapping("/scannedtext")
     public ResponseEntity<ScannedText> createNewScannedtext(@RequestParam("text") String text, @RequestParam("source") String source, @RequestParam("id") Long id, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(scannedTextService.createNewScannedText(text, source, id, file), HttpStatus.CREATED);
     }

     @DeleteMapping("/scannedtext/{id}")
     public ResponseEntity<HttpStatus> deleteScannedText(@PathVariable Long id) {
        scannedTextService.deleteScannedText(id);
        return new ResponseEntity<>(HttpStatus.OK);
     }
    
}
