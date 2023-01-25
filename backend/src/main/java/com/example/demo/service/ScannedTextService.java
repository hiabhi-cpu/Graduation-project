package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ScannedText;

public interface ScannedTextService {
    ScannedText getScannedText(Long id);
    List<ScannedText> getAllScannedTexts();
    ScannedText createNewScannedText(String text, String source, Long id, MultipartFile file);
    void deleteScannedText(Long id);
}
