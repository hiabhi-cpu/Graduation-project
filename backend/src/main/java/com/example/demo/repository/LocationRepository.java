package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
    
}
