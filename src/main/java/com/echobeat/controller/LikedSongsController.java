package com.echobeat.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.LikedSongs;
import com.echobeat.repository.LikedSongsRepository;

@CrossOrigin(origins = "http://localhost:8081") // Adjust origin as needed
@RestController
@RequestMapping("/api") // Adjust path based on your API design
public class LikedSongsController {

    @Autowired
    LikedSongsRepository likedSongsRepository;

    @GetMapping("/likedSongs/userId/{userId}")
    public ResponseEntity<List<LikedSongs>> getLikedSongsByUserId(@PathVariable("userId") long userId) {
        try {
            List<LikedSongs> likedSongs = likedSongsRepository.findByUserId(userId);

            if (likedSongs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(likedSongs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/likedSongs/trackId/{trackId}")
    public ResponseEntity<List<LikedSongs>> getLikedSongByTrackId(@PathVariable("trackId") long trackId) {
        try {
            List<LikedSongs> likedSong = likedSongsRepository.findByTrackId(trackId);

            if (likedSong != null) {
                return new ResponseEntity<>(likedSong, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/likedSongs")
    public ResponseEntity<String> saveLikedSong(@RequestBody LikedSongs likedSongs) {
        try {
            likedSongsRepository.save(likedSongs);
            return new ResponseEntity<>("Liked song saved successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}