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

import com.echobeat.model.TrackCreator;
import com.echobeat.repository.TrackCreatorInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PodcastCreatorController {

    @Autowired
    private TrackCreatorInterface podcastCreatorRepository;

    @GetMapping("/podcast-creators")
    public ResponseEntity<List<TrackCreator>> getAllPodcastCreators() {
        try {
            List<TrackCreator> podcastCreators = new ArrayList<>();
            podcastCreatorRepository.findAll().forEach(podcastCreators::add);

            if (podcastCreators.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(podcastCreators, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/podcast-creators/{trackId}/{artistId}")
    public ResponseEntity<TrackCreator> getPodcastCreatorById(@PathVariable("trackId") long trackId,
                                                                 @PathVariable("artistId") long artistId) {
        TrackCreator podcastCreator = podcastCreatorRepository.findByTrackIdAndArtistId(trackId, artistId);

        if (podcastCreator != null) {
            return new ResponseEntity<>(podcastCreator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/podcast-creators")
    public ResponseEntity<TrackCreator> createPodcastCreator(@RequestBody TrackCreator podcastCreator) {
        try {
            TrackCreator createdPodcastCreator = podcastCreatorRepository.save(podcastCreator);
            return new ResponseEntity<>(createdPodcastCreator, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/podcast-creators/{trackId}/{artistId}")
    public ResponseEntity<String> updatePodcastCreator(@PathVariable("trackId") long trackId,
                                                       @PathVariable("artistId") long artistId,
                                                       @RequestBody TrackCreator podcastCreator) {
        podcastCreator.setTrack_id(trackId);
        podcastCreator.setArtist_id(artistId);

        try {
            podcastCreatorRepository.update(podcastCreator);
            return new ResponseEntity<>("PodcastCreator was updated successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot update PodcastCreator with id=" + trackId + " and artistId=" + artistId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/podcast-creators/{trackId}/{artistId}")
public ResponseEntity<String> deletePodcastCreator(@PathVariable("trackId") long trackId,
                                                   @PathVariable("artistId") long artistId) {
    try {
        TrackCreator deletedPodcastCreator = podcastCreatorRepository.delete(trackId, artistId);
        if (deletedPodcastCreator != null) {
            return new ResponseEntity<>("PodcastCreator was deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find PodcastCreator with trackId=" + trackId + " and artistId=" + artistId, HttpStatus.NOT_FOUND);
        }
    } catch (Exception e) {
        return new ResponseEntity<>("Cannot delete PodcastCreator.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}

