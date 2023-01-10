package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long>{
    
}
