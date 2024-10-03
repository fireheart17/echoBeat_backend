package com.echobeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.echobeat.model.LikedPodcasts;
import com.echobeat.repository.LikedPodcastsInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LikedPodcastsController {

    @Autowired
    private LikedPodcastsInterface likedPodcastsRepository;

    // Endpoint to add a liked podcast
    @PostMapping("/liked-podcasts")
    public ResponseEntity<String> addLikedPodcast(@RequestBody LikedPodcasts likedPodcast) {
        int result = likedPodcastsRepository.addLikedPodcast(likedPodcast);
        if (result > 0) {
            return new ResponseEntity<>("Podcast liked successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Unable to like podcast.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to remove a liked podcast
    @DeleteMapping("/liked-podcasts/{user_id}/{podcast_id}")
    public ResponseEntity<String> removeLikedPodcast(@PathVariable long user_id, @PathVariable long podcast_id) {
        int result = likedPodcastsRepository.removeLikedPodcast(user_id, podcast_id);
        if (result > 0) {
            return new ResponseEntity<>("Podcast unliked successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Liked podcast not found.", HttpStatus.NOT_FOUND);
        }
    }
}
