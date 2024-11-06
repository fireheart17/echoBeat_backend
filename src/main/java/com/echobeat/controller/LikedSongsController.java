package com.echobeat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.LikedSongs;
import com.echobeat.model.Track;
import com.echobeat.repository.LikedSongsRepository;
import com.echobeat.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:8081") // Adjust origin as needed
@RestController
@RequestMapping("/api") // Adjust path based on your API design
public class LikedSongsController {

    @Autowired
    LikedSongsRepository likedSongsRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/likedSongs/userId/{userId}")
    public ResponseEntity<List<Track>> getLikedSongsByUserId(@PathVariable("userId") long userId) {
        try {
            List<Track> likedSongs = likedSongsRepository.findByUserId(userId);

            if (likedSongs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(likedSongs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/likedSongsFromToken")
    public ResponseEntity<List<String>> getLikedSongsByToken(HttpServletRequest request) {
        long userId = jwtUtil.AuthenticateToken(request);
        try {
            List<Track> likedSongs = likedSongsRepository.findByUserId(userId);
            if (likedSongs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<String> resp = new ArrayList<>();
            for (Track item : likedSongs) {
                resp.add(item.getTrackId());
            }

            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/likedSongs/trackId/{trackId}")
    public ResponseEntity<List<LikedSongs>> getLikedSongByTrackId(@PathVariable("trackId") String trackId) {
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

    @DeleteMapping("/likedSongs/{userId}/{trackId}")
    public ResponseEntity<String> deleteLikedSong(@PathVariable("userId") long userId, @PathVariable("trackId") String trackId) {
        try {
            likedSongsRepository.delete(userId, trackId);
            return new ResponseEntity<>("Liked song deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}