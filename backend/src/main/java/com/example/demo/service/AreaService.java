package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Area;

public interface AreaService {
    Area getArea(Long id);
    List<Area> getAllAreas();
    Area createNewArea(Area area);
}
