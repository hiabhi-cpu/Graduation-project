package com.example.demo.service;

public interface ImageUtilityService {
    byte[] compressImage(byte[] data);
    byte[] deCompressImage(byte[] data);
}
