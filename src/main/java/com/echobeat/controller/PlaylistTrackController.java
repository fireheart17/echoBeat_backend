package com.echobeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.PlaylistTrack;
import com.echobeat.repository.PlaylistTrackRepository;
import com.echobeat.model.Track;

@CrossOrigin(origins = "http://localhost:8081") // Adjust origin as needed
@RestController
@RequestMapping("/api/playlistsTracks") // Adjust path based on your API design
public class PlaylistTrackController {

    @Autowired
    private PlaylistTrackRepository playlistTrackRepository;

    @PostMapping("")
    public ResponseEntity<String> addTrackToPlaylist(@RequestBody PlaylistTrack playlistTrack) {
        try {
            playlistTrackRepository.save(playlistTrack);
            return new ResponseEntity<>("Track added to playlist successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{playlistId}/{trackId}")
    public ResponseEntity<String> removeTrackFromPlaylist(@PathVariable("playlistId") long playlistId,
            @PathVariable("trackId") String trackId) {
        try {
            playlistTrackRepository.delete(playlistId, trackId);
            return new ResponseEntity<>("Track removed from playlist successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error removing track.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/playlist/{playlistId}")
    public ResponseEntity<List<Track>> getPlaylistTracks(@PathVariable("playlistId") long playlistId) {
        List<Track> playlistTracks = playlistTrackRepository.findByPlaylistId(playlistId);

        if (playlistTracks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(playlistTracks, HttpStatus.OK);
        }
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<List<PlaylistTrack>> getPlaylistsForTrack(@PathVariable("trackId") String trackId) {
        List<PlaylistTrack> playlistTracks = playlistTrackRepository.findByTrackId(trackId);

        if (playlistTracks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(playlistTracks, HttpStatus.OK);
        }
    }

}