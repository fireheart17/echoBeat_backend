package com.echobeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.Playlist;
import com.echobeat.repository.PlaylistRepository;


@CrossOrigin(origins = "http://localhost:8081") // Adjust origin as needed
@RestController
@RequestMapping("/api/playlists")  // Adjust path based on your API design
public class PlaylistController {

  @Autowired
  private PlaylistRepository playlistRepository;


  @GetMapping("/{playlistId}")
  public ResponseEntity<Playlist> getPlaylistById(@PathVariable("playlistId") long playlistId) {
    Playlist playlist = playlistRepository.findByPlaylistId(playlistId);

    if (playlist != null) {
      return new ResponseEntity<>(playlist, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Playlist>> getPlaylistsByUserId(@PathVariable("userId") long userId) {
    List<Playlist> playlists = playlistRepository.findByUserId(userId);

    if (playlists.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
  }

  @PostMapping("")
  public ResponseEntity<String> savePlaylist(@RequestBody Playlist playlist) {
    try {
      playlistRepository.save(playlist);
      return new ResponseEntity<>("Playlist saved successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{playlistId}")
  public ResponseEntity<String> updatePlaylist(@PathVariable("playlistId") long playlistId, @RequestBody Playlist updatedPlaylist) {
    Playlist existingPlaylist = playlistRepository.findByPlaylistId(playlistId);

    if (existingPlaylist != null) {
      existingPlaylist.setTitle(updatedPlaylist.getTitle());
      existingPlaylist.setDuration(updatedPlaylist.getDuration());
      playlistRepository.update(existingPlaylist);
      return new ResponseEntity<>("Playlist updated successfully.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Playlist not found.", HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{playlistId}")
  public ResponseEntity<String> deletePlaylist(@PathVariable("playlistId") long playlistId) {
    try {
      int result = playlistRepository.delete(playlistId);

      if (result == 0) {
        return new ResponseEntity<>("Playlist not found.", HttpStatus.NOT_FOUND);
      } else {
        return new ResponseEntity<>("Playlist deleted successfully.", HttpStatus.OK);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}