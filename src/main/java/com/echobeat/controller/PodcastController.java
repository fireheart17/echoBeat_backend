package com.echobeat.controller;

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
import java.util.List;
import com.echobeat.model.Podcast;
import com.echobeat.repository.PodcastInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PodcastController {

  @Autowired
  PodcastInterface podcastRepository;


  // Get a podcast by ID
  @GetMapping("/podcasts/{id}")
  public ResponseEntity<Podcast> getPodcastById(@PathVariable("id") long id) {
    Podcast podcast = podcastRepository.findById(id);

    if (podcast != null) {
      return new ResponseEntity<>(podcast, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Create a new podcast
  @PostMapping("/podcasts")
  public ResponseEntity<String> createPodcast(@RequestBody Podcast podcast) {
    try {
      podcastRepository.save(new Podcast(podcast.getPodcast_name(),
                                         podcast.getGenre(),
                                         podcast.getLyrics(),
                                         podcast.getDuration(),
                                         podcast.getCountry(),
                                         podcast.getLike_count(),
                                         podcast.getListen_count()));
      return new ResponseEntity<>("Podcast was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Update a podcast
  @PostMapping("/podcasts/{id}")
  public ResponseEntity<String> updatePodcast(@PathVariable("id") long id, @RequestBody Podcast podcast) {
    Podcast _podcast = podcastRepository.findById(id);

    if (_podcast != null) {
      _podcast.setPodcast_name(podcast.getPodcast_name());
      _podcast.setGenre(podcast.getGenre());
      _podcast.setLyrics(podcast.getLyrics());
      _podcast.setDuration(podcast.getDuration());
      _podcast.setCountry(podcast.getCountry());
      _podcast.setLike_count(podcast.getLike_count());
      _podcast.setListen_count(podcast.getListen_count());

      podcastRepository.update(_podcast);
      return new ResponseEntity<>("Podcast was updated successfully.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Cannot find Podcast with id=" + id, HttpStatus.NOT_FOUND);
    }
  }

  // Delete a podcast by ID
  @PostMapping("/podcasts/delete/{id}")
  public ResponseEntity<String> deletePodcast(@PathVariable("id") long id) {
    try {
      Podcast podcast = podcastRepository.deleteById(id);
      if (podcast != null) {
        return new ResponseEntity<>("Podcast was deleted successfully.", HttpStatus.OK);
      } else {
        return new ResponseEntity<>("Cannot find Podcast with id=" + id, HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot delete Podcast.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/podcasts/search/{keyword}")
  public ResponseEntity<List<Podcast>> searchPodcast(@PathVariable("keyword") String keyword) {
    try {
      List<Podcast> podcasts = podcastRepository.search(keyword);

      if (podcasts.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(podcasts, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
