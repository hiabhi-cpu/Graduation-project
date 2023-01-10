package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Region;

public interface RegionRepository extends CrudRepository<Region, Long>{
    
}
