package com.example.demo.entity;

import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;

    private String text; 

    public Location() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Region region; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Tag tag; 

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private Set<Image> images;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private Set<ScannedText> scannedTexts;

    public Location(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public void setImages(Image image) {
    }

    public Set<ScannedText> getScannedTexts() {
        return scannedTexts;
    }

    public void setScannedTexts(Set<ScannedText> scannedTexts) {
        this.scannedTexts = scannedTexts;
    }

    public void setScannedTexts(ScannedText scannedText) {
    }

}
