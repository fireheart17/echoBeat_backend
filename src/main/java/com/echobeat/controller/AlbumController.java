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

import com.echobeat.model.Album;
import com.echobeat.repository.AlbumInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AlbumController {

    @Autowired
    AlbumInterface albumRepository;

    // Get all albums
    // @GetMapping("/albums")
    // public ResponseEntity<List<Album>> getAllAlbums(@RequestParam(required = false) String title) {
    //     try {
    //         List<Album> albums = new ArrayList<>();

    //         // Here, we fetch all albums, but filtering logic by title can be added later
    //         albumRepository.findAll().forEach(albums::add);

    //         if (albums.isEmpty()) {
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //         }

    //         return new ResponseEntity<>(albums, HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // Get album by ID
    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") long id) {
        Album album = albumRepository.findById(id);

        if (album!=null) {
            return new ResponseEntity<>(album, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new album
    @PostMapping("/albums")
    public ResponseEntity<String> createAlbum(@RequestBody Album album) {
        try {
            albumRepository.save(new Album(
                album.getAlbum_id(),
                album.getTitle(),
                album.getGenre(),
                album.getRelease_date()
            ));
            return new ResponseEntity<>("Album was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an album by ID
    // @PutMapping("/albums/{id}")
    // public ResponseEntity<String> updateAlbum(@PathVariable("id") long id, @RequestBody Album album) {
    //     Album existingAlbum = albumRepository.findById(id);

    //     if (existingAlbum!=null) {
    //         Album _album = existingAlbum.get();
    //         _album.setTitle(album.getTitle());
    //         _album.setGenre(album.getGenre());
    //         _album.setRelease_date(album.getRelease_date());

    //         albumRepository.update(_album);
    //         return new ResponseEntity<>("Album was updated successfully.", HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>("Cannot find Album with id=" + id, HttpStatus.NOT_FOUND);
    //     }
    // }

    // Delete an album by ID
    @DeleteMapping("/albums/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable("id") long id) {
        try {
            albumRepository.deleteById(id);
            return new ResponseEntity<>("Album was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete album.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
