package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.ScannedText;

public interface ScannedTextRepository extends CrudRepository<ScannedText, Long>{
    
}
