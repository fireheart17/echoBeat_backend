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

import com.echobeat.model.LikedPlaylists;
import com.echobeat.model.Track;
import com.echobeat.model.Playlist;
import com.echobeat.repository.LikedPlaylistsInterface;
import com.echobeat.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LikedPlaylistsController {

    @Autowired
    private LikedPlaylistsInterface likedPlaylistRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/likedplaylists/{userId}/{playlistId}")
    public ResponseEntity<Boolean> getLikedPlaylistById(@PathVariable("userId") long userId, 
                                                                @PathVariable("playlistId") long playlistId) {
        boolean userLikedPlaylist = likedPlaylistRepository.findLikedPlaylist(userId, playlistId);

        return new ResponseEntity<>(userLikedPlaylist,HttpStatus.ACCEPTED);
    }

    @PostMapping("/likedplaylists")
    public ResponseEntity<String> createLikedPlaylist(@RequestBody LikedPlaylists likedPlaylists) {
        try {
            likedPlaylistRepository.saveLikedPlaylist(new LikedPlaylists(
                likedPlaylists.getUser_id(),
                likedPlaylists.getPlaylist_id()
            ));
            return new ResponseEntity<>("Liked Playlist created.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PostMapping("/likedplaylists/{userId}/{playlistId}")
    // public ResponseEntity<String> updateLikedPlaylist(@PathVariable("userId") long userId, 
    //                                                   @PathVariable("playlistId") long playlistId, 
    //                                                   @RequestBody LikedPlaylists likedPlaylists) {
    //     LikedPlaylists existingLikedPlaylist = likedPlaylistRepository.findLikedPlaylist(userId, playlistId);

    //     if (existingLikedPlaylist != null) {
    //         existingLikedPlaylist.setPlaylist_id(likedPlaylists.getPlaylist_id());  // Assuming you might want to update the playlistId

    //         likedPlaylistRepository.updateLikedPlaylist(existingLikedPlaylist);
    //         return new ResponseEntity<>("Liked Playlist was updated successfully.", HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>("Cannot find Liked Playlist with userId=" + userId + " and playlistId=" + playlistId, HttpStatus.NOT_FOUND);
    //     }1
    // }

    @DeleteMapping("/likedplaylists/{userId}/{playlistId}")
    public ResponseEntity<String> deleteLikedPlaylist(@PathVariable("userId") long userId, 
                                                      @PathVariable("playlistId") long playlistId) {
        int deletedCount = likedPlaylistRepository.deleteLikedPlaylist(userId, playlistId);
        if (deletedCount > 0) {
            return new ResponseEntity<>("Liked Playlist was deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Liked Playlist with userId=" + userId + " and playlistId=" + playlistId, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/likedPlaylists/userId/{userId}")
    public ResponseEntity<List<Playlist>> getLikedPlaylistsByUserId(@PathVariable("userId") long userId) {
        try {
            List<Playlist> likedPlaylists = likedPlaylistRepository.findLikedPlaylistsByUserId(userId);

            if (likedPlaylists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(likedPlaylists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/likedPlaylistsFromToken")
    public ResponseEntity<List<String>> getLikedSongsByToken(HttpServletRequest request) {
        long userId = jwtUtil.AuthenticateToken(request);
        try {
            List<Playlist> likedSongs = likedPlaylistRepository.findLikedPlaylistsByUserId(userId);
            if (likedSongs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<String> resp = new ArrayList<>();
            for (Playlist item : likedSongs) {
                resp.add(String.valueOf(item.getPlaylist_id()));
            }

            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
