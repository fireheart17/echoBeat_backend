package com.echobeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.echobeat.model.LikedAlbums;
import com.echobeat.repository.LikedAlbumsInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LikedAlbumsController {

    @Autowired
    private LikedAlbumsInterface likedAlbumsRepository;

    @PostMapping("/liked-albums")
    public ResponseEntity<String> addLikedAlbum(@RequestBody LikedAlbums likedAlbum) {
        int result = likedAlbumsRepository.addLikedAlbum(likedAlbum);
        if (result > 0) {
            return new ResponseEntity<>("Album liked successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Unable to like album.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/liked-albums/{user_id}/{album_id}")
    public ResponseEntity<String> removeLikedAlbum(@PathVariable long user_id, @PathVariable long album_id) {
        int result = likedAlbumsRepository.removeLikedAlbum(user_id, album_id);
        if (result > 0) {
            return new ResponseEntity<>("Album unliked successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Liked album not found.", HttpStatus.NOT_FOUND);
        }
    }
}
