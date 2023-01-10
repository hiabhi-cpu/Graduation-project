package com.example.demo.service;

import com.example.demo.entity.ScannedText;

public interface ScannedTextService {
    ScannedText getScannedText(Long id);
    ScannedText createNewRegion(ScannedText scannedText);
}
