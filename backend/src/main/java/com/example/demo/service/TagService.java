package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Tag;

public interface TagService {
    Tag getTag(Long id);
    List<Tag> getAllTags();
    Tag createNewTag(String name, String color);
}

