package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class ScannedText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Lob
	@Column(name = "imageData", columnDefinition="MEDIUMBLOB", length = 1000)
    private byte[] imageData; 

    private String text;

    private String source; 

    @JsonIgnore
    @ManyToOne
    private Location location;

    public ScannedText() {
    }

    public ScannedText(byte[] imageData, String text, String source) {
        this.imageData = imageData;
        this.text = text;
        this.source = source;
    }

    public ScannedText(Long id, byte[] imageData, String text, String source) {
        this.id = id;
        this.imageData = imageData;
        this.text = text;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    } 
    
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
