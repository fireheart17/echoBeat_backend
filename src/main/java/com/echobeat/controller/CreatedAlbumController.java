package com.echobeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.echobeat.model.CreatedAlbum;
import com.echobeat.model.Album;
import com.echobeat.repository.CreatedAlbumInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CreatedAlbumController {

    @Autowired
    private CreatedAlbumInterface createdAlbumRepository;

    @PostMapping("/created-album")
    public ResponseEntity<String> addCreatedAlbum(@RequestBody CreatedAlbum createdAlbum) {
        int result = createdAlbumRepository.addCreatedAlbum(createdAlbum);
        if (result > 0) {
            return new ResponseEntity<>("Album created successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Unable to create album.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/created-album/{album_id}/{artist_id}")
    public ResponseEntity<String> removeCreatedAlbum(@PathVariable long album_id, @PathVariable long artist_id) {
        int result = createdAlbumRepository.removeCreatedAlbum(album_id, artist_id);
        if (result > 0) {
            return new ResponseEntity<>("Album removed successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("album not found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/created-album/artist-id/{artist_id}")
    public ResponseEntity<List<Album>> getAlbumsByArtistId(@PathVariable long artist_id) {
        try {
            List<Album> createdAlbums = createdAlbumRepository.getAlbumsByArtistId(artist_id);

            if (!createdAlbums.isEmpty()) {
                return new ResponseEntity<>(createdAlbums, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
