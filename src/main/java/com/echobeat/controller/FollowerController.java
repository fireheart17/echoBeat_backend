package com.echobeat.controller;

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

import com.echobeat.model.Follower;
import com.echobeat.model.User;
import com.echobeat.repository.FollowerInterface;
import com.echobeat.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FollowerController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    FollowerInterface followerRepository;

    @GetMapping("/addfollower/{artist_id}")//C1
    public ResponseEntity<String> C1(@PathVariable("artist_id") long artist_id,HttpServletRequest request) {
        long user_id = jwtUtil.AuthenticateToken(request);
        try {
            int result = followerRepository.addFollowerToken(artist_id,user_id);
            if (result > 0) {
                return new ResponseEntity<>("Follower added successfully.", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Unable to add follower.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/checkfollower/{artist_id}")//C1
    public ResponseEntity<String> C2(@PathVariable("artist_id") long artist_id,HttpServletRequest request) {
        long user_id = jwtUtil.AuthenticateToken(request);
        try {
            boolean result = followerRepository.checkFollowerToken(artist_id,user_id);
            if (result ) {
                return new ResponseEntity<>("True", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("False", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getfollowers/{artist_id}")//C1
    public ResponseEntity<List<User>> C3(@PathVariable("artist_id") long artist_id) {
        // long user_id = jwtUtil.AuthenticateToken(request);
        try {
            List<User> users = followerRepository.getFollowers(artist_id);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(users, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    
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
    @DeleteMapping("/followers/{artist_id}")
    public ResponseEntity<String> removeFollower(@PathVariable("artist_id") long artist_id,HttpServletRequest request) {
        long user_id = jwtUtil.AuthenticateToken(request);
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
