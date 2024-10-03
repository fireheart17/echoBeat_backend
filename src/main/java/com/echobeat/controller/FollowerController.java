package com.echobeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.Follower;
import com.echobeat.repository.FollowerInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FollowerController {

    @Autowired
    FollowerInterface followerRepository;

    // Add a follower
    @PostMapping("/followers")
    public ResponseEntity<String> addFollower(@RequestBody Follower follower) {
        try {
            int result = followerRepository.addFollower(follower);
            if (result > 0) {
                return new ResponseEntity<>("Follower added successfully.", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Unable to add follower.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Remove a follower by artist_id and user_id
    @DeleteMapping("/followers/{artist_id}/{user_id}")
    public ResponseEntity<String> removeFollower(@PathVariable("artist_id") long artist_id, @PathVariable("user_id") long user_id) {
        try {
            int result = followerRepository.removeFollower(artist_id, user_id);
            if (result > 0) {
                return new ResponseEntity<>("Follower removed successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Follower not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
