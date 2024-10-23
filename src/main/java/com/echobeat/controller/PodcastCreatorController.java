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

import com.echobeat.model.PodcastCreator;
import com.echobeat.repository.PodcastCreatorInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PodcastCreatorController {

    @Autowired
    private PodcastCreatorInterface podcastCreatorRepository;

    @GetMapping("/podcast-creators")
    public ResponseEntity<List<PodcastCreator>> getAllPodcastCreators() {
        try {
            List<PodcastCreator> podcastCreators = new ArrayList<>();
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
    public ResponseEntity<PodcastCreator> getPodcastCreatorById(@PathVariable("podcastId") long podcastId,
                                                                 @PathVariable("artistId") long artistId) {
        PodcastCreator podcastCreator = podcastCreatorRepository.findByPodcastIdAndArtistId(podcastId, artistId);

        if (podcastCreator != null) {
            return new ResponseEntity<>(podcastCreator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/podcast-creators")
    public ResponseEntity<PodcastCreator> createPodcastCreator(@RequestBody PodcastCreator podcastCreator) {
        try {
            PodcastCreator createdPodcastCreator = podcastCreatorRepository.save(podcastCreator);
            return new ResponseEntity<>(createdPodcastCreator, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/podcast-creators/{podcastId}/{artistId}")
    public ResponseEntity<String> updatePodcastCreator(@PathVariable("podcastId") long podcastId,
                                                       @PathVariable("artistId") long artistId,
                                                       @RequestBody PodcastCreator podcastCreator) {
        podcastCreator.setPodcast_id(podcastId);
        podcastCreator.setArtist_id(artistId);

        try {
            podcastCreatorRepository.update(podcastCreator);
            return new ResponseEntity<>("PodcastCreator was updated successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot update PodcastCreator with id=" + podcastId + " and artistId=" + artistId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/podcast-creators/{podcastId}/{artistId}")
public ResponseEntity<String> deletePodcastCreator(@PathVariable("podcastId") long podcastId,
                                                   @PathVariable("artistId") long artistId) {
    try {
        PodcastCreator deletedPodcastCreator = podcastCreatorRepository.delete(podcastId, artistId);
        if (deletedPodcastCreator != null) {
            return new ResponseEntity<>("PodcastCreator was deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find PodcastCreator with podcastId=" + podcastId + " and artistId=" + artistId, HttpStatus.NOT_FOUND);
        }
    } catch (Exception e) {
        return new ResponseEntity<>("Cannot delete PodcastCreator.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}

