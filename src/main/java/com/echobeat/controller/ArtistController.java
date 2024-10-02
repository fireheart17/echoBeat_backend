package com.echobeat.controller;

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

import com.echobeat.model.Artist;
import com.echobeat.repository.ArtistInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ArtistController {

    @Autowired
    ArtistInterface artistRepository;


    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable("id") long id) {
        Artist artist = artistRepository.findArtistById(id);

        if (artist != null) {
            return new ResponseEntity<>(artist, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/artists")
    public ResponseEntity<String> createArtist(@RequestBody Artist artist) {
        try {
            artistRepository.saveArtist(new Artist(
                artist.getFirst_name(),
                artist.getLast_name(),
                artist.getPassword(),
                artist.getGlobal_rank(),
                artist.getCountry(),
                artist.getAbout(),
                artist.getFollower_count()
            ));
            return new ResponseEntity<>("created", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/artists/{id}")
    public ResponseEntity<String> updateArtist(@PathVariable("id") long id, @RequestBody Artist artist) {
        Artist existingArtist = artistRepository.findArtistById(id);

        if (existingArtist != null) {
            existingArtist.setFirst_name(artist.getFirst_name());
            existingArtist.setLast_name(artist.getLast_name());
            existingArtist.setPassword(artist.getPassword());
            existingArtist.setGlobal_rank(artist.getGlobal_rank());
            existingArtist.setCountry(artist.getCountry());
            existingArtist.setAbout(artist.getAbout());
            existingArtist.setFollower_count(artist.getFollower_count());

            artistRepository.updateArtist(existingArtist);
            return new ResponseEntity<>("Artist was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find artist with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<String> deleteArtist(@PathVariable("id") long id) {
        Artist deletedArtist = artistRepository.deleteArtist(id);
        if (deletedArtist != null) {
            return new ResponseEntity<>("Artist was deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find artist with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
}
