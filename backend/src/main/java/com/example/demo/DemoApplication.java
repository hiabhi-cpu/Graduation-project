package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Tag;
import com.example.demo.repository.TagRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	 CommandLineRunner init(TagRepository repo) {
	 	return args -> {
			 Tag tag1 = new Tag("Gruva", "#0b8c27");
			 Tag tag2 = new Tag("Vattenhjul", "#15b0a8");
			 Tag tag3 = new Tag("Damm", "#b0ab15");
			 Tag tag4 = new Tag("Sjötransporter", "#1515b0");
			repo.save(tag1);
			repo.save(tag2);
			repo.save(tag3);
			repo.save(tag4);
 	};
	 }
	
}
