package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Location;
import com.example.demo.entity.Region;

public interface LocationRepository extends CrudRepository<Location, Long> {
    List <Location> findAllByRegion(Region region);

    public List<Location> findByTextContainingIgnoreCase(String keyword);
}
