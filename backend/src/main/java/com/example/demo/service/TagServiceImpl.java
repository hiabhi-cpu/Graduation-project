package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Tag;
import com.example.demo.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag getTag(Long id) {
        if(tagRepository.findById(id).isPresent()) {
            return tagRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request"); 
    }

    @Override
    public List<Tag> getAllTags() {
        return (List<Tag>)tagRepository.findAll();
    }

    @Override
    public Tag createNewTag(String name, String color) {
        Tag tag = new Tag(name, color);
        return tagRepository.save(tag);
    }

	@Override
	public void deletTag(Long id) {
		if(tagRepository.findById(id).isPresent()) {
			tagRepository.deleteById(id);
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
		}
		
	}

	@Override
	public Tag updateTag(Long id, String name, String color) {
		// TODO Auto-generated method stub
		if(tagRepository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
		}
		Tag tag=tagRepository.findById(id).get();
		tag.setName(name);
		tag.setColor(color);
		return tagRepository.save(tag);
	}
 
}
