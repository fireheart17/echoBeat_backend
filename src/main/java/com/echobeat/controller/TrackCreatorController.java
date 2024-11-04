package com.echobeat.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.echobeat.model.Artist;
import com.echobeat.model.TrackCreator;
import com.echobeat.repository.TrackCreatorInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrackCreatorController {

    @Autowired
    private TrackCreatorInterface trackCreatorRepository;

    @GetMapping("/track-creators")
    public ResponseEntity<List<TrackCreator>> getAllTrackCreators() {
        try {
            List<TrackCreator> trackCreators = new ArrayList<>();
            trackCreatorRepository.findAll().forEach(trackCreators::add);

            if (trackCreators.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(trackCreators, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/track-creators/{trackId}/{artistId}")
    public ResponseEntity<TrackCreator> getTrackCreatorById(@PathVariable("trackId") String trackId,
            @PathVariable("artistId") long artistId) {
        TrackCreator trackCreator = trackCreatorRepository.findByTrackIdAndArtistId(trackId, artistId);

        if (trackCreator != null) {
            return new ResponseEntity<>(trackCreator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/track-creators")
    public ResponseEntity<TrackCreator> createTrackCreator(@RequestBody TrackCreator trackCreator) {
        try {
            TrackCreator createdTrackCreator = trackCreatorRepository.save(trackCreator);
            return new ResponseEntity<>(createdTrackCreator, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/track-creators/{trackId}/{artistId}")
    public ResponseEntity<String> updateTrackCreator(@PathVariable("trackId") String trackId,
            @PathVariable("artistId") long artistId,
            @RequestBody TrackCreator trackCreator) {
        trackCreator.setTrack_id(trackId);
        trackCreator.setArtist_id(artistId);

        try {
            trackCreatorRepository.update(trackCreator);
            return new ResponseEntity<>("TrackCreator was updated successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot update TrackCreator with id=" + trackId + " and artistId=" + artistId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/track-creators/{trackId}/{artistId}")
    public ResponseEntity<String> deleteTrackCreator(@PathVariable("trackId") String trackId,
            @PathVariable("artistId") long artistId) {
        try {
            TrackCreator deletedTrackCreator = trackCreatorRepository.delete(trackId, artistId);
            if (deletedTrackCreator != null) {
                return new ResponseEntity<>("TrackCreator was deleted successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cannot find TrackCreator with trackId=" + trackId + " and artistId=" + artistId, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete TrackCreator.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTrackArtists/{trackId}")
    public ResponseEntity<List<Artist>> getArtistsByTrackId(@PathVariable("trackId") String trackId) {
        List<Artist> artists= trackCreatorRepository.getArtistsByTrackId(trackId);

        if (artists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(artists, HttpStatus.OK);
        }
    }

}
