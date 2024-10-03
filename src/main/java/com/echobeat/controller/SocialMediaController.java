package com.echobeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.SocialMedia;
import com.echobeat.repository.SocialMediaInterface;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SocialMediaController {

    @Autowired
    private SocialMediaInterface socialMediaRepository;


    @GetMapping("/socialmedia/{artistId}/{socialMediaType}")
    public ResponseEntity<SocialMedia> getSocialMediaById(
            @PathVariable("artistId") long artistId, 
            @PathVariable("socialMediaType") String socialMediaType) {
        
        SocialMedia socialMedia = socialMediaRepository.findById(artistId, socialMediaType);

        if (socialMedia != null) {
            return new ResponseEntity<>(socialMedia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/socialmedia")
    public ResponseEntity<SocialMedia> createSocialMedia(@RequestBody SocialMedia socialMedia) {
        try {
            SocialMedia createdSocialMedia = socialMediaRepository.save(socialMedia);
            return new ResponseEntity<>(createdSocialMedia, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/socialmedia")
    public ResponseEntity<SocialMedia> updateSocialMedia(@RequestBody SocialMedia socialMedia) {
        try {
            SocialMedia updatedSocialMedia = socialMediaRepository.update(socialMedia);
            return new ResponseEntity<>(updatedSocialMedia, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/socialmedia/{artistId}/{socialMediaType}")
    public ResponseEntity<SocialMedia> deleteSocialMedia(
            @PathVariable("artistId") long artistId, 
            @PathVariable("socialMediaType") String socialMediaType) {
        
        SocialMedia deletedSocialMedia = socialMediaRepository.delete(artistId, socialMediaType);

        if (deletedSocialMedia != null) {
            return new ResponseEntity<>(deletedSocialMedia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
