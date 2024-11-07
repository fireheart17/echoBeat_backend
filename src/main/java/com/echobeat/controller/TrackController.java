package com.echobeat.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PatchMapping;

import com.echobeat.model.Track;
import com.echobeat.repository.TrackInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrackController {

    @Autowired
    TrackInterface trackRepository;

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable("id") String id) {
        Track track = trackRepository.findById(id);

        if (track != null) {
            return new ResponseEntity<>(track, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tracks")
    public ResponseEntity<String> createTrack(@RequestBody Track track) {
        try {
            System.err.println(track.getTrackId());
            trackRepository.save(track);
            return new ResponseEntity<>("Track was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tracks/{id}")
    public ResponseEntity<String> updateTrack(@PathVariable("id") String id, @RequestBody Track track) {
        Track existingTrack = trackRepository.findById(id);

        if (existingTrack != null) {
            existingTrack.setTrack_name(track.getTrack_name());
            existingTrack.setGenre(track.getGenre());
            existingTrack.setLyrics(track.getLyrics());
            existingTrack.setDuration(track.getDuration());
            existingTrack.setCountry(track.getCountry());
            existingTrack.setLike_count(track.getLike_count());
            existingTrack.setListen_count(track.getListen_count());
            existingTrack.setAlbum_id(track.getAlbum_id());

            trackRepository.update(existingTrack);
            return new ResponseEntity<>("Track was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find track with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<String> deleteTrack(@PathVariable("id") String id) {
        int result = trackRepository.deleteById(id);
        if (result > 0) {
            return new ResponseEntity<>("Track was deleted successfully.", HttpStatus.OK);
        } else {    
            return new ResponseEntity<>("Cannot find track with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("tracks/albums/{albumId}")
    public ResponseEntity<List<Track>> getTracksByAlbumId(@PathVariable("albumId") String albumId) {
        List<Track> tracks = trackRepository.findByAlbumId(albumId);

        if (tracks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }
    }

    @GetMapping("/newtracks")
    public ResponseEntity<List<Track>> getNewTracks() {
        List<Track> tracks = trackRepository.newTracks();

        if (tracks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }
    }

    @GetMapping("/toppicks")
    public ResponseEntity<List<Track>> getTopPicks() {
        List<Track> tracks = trackRepository.topPicks();

        if (tracks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }
    }

    @GetMapping("tracks/search/{keyword}")
    public ResponseEntity<List<Track>> searchTracks(@PathVariable("keyword") String keyword) {
        List<Track> tracks = trackRepository.Search(keyword);

        if (tracks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<List<Track>> tracksInAlbum(@PathVariable("id") long id) {
        try {
            List<Track> tracks = trackRepository.tracksInAlbum(id);
            if (tracks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tracks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/tracks/{id}/incrementListen")
    public ResponseEntity<String> incrementListenCount(@PathVariable("id") String id) {
        int result = trackRepository.incrementListenCount(id);

        if (result > 0) {
            return new ResponseEntity<>("Listen count incremented successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Track not found or failed to update.", HttpStatus.NOT_FOUND);
        }
    }

}
