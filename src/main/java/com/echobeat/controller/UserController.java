package com.echobeat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.Artist;
import com.echobeat.model.User;
import com.echobeat.repository.UserInterface;
import com.echobeat.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    UserInterface userRepository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String title) {
        try {
            List<User> users = new ArrayList<>();

            userRepository.findAll().forEach(users::add);

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/validate")
    public long GetUserIdFromToken(HttpServletRequest request) {
        long user_id = jwtUtil.AuthenticateToken(request);
        return user_id;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") long id) {
        // System.out.println(id);
        User user = userRepository.findById(id);
        if (user != null) {
            String token = jwtUtil.generateToken(user.getUserId());
            // System.out.println("token : "+token);
            return new ResponseEntity<>(token, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 

    @GetMapping("/users/profile")
    public ResponseEntity<User> getUserProfile(HttpServletRequest request) {
        // System.out.println(id);
        long id = jwtUtil.AuthenticateToken(request);
        User user = userRepository.findById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userRepository.save(new User(user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    encoder.encode(user.getPassword()),
                    user.getDob(),
                    user.getAge(),
                    user.getGender(),
                    user.getSubscriptionId(),
                    user.getSubscriptionEndDate()));
            return new ResponseEntity<>("User was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> handleLogin(@RequestBody User user) {
        try {
            User login_user = userRepository.findByCredentials(user.getUsername(), user.getPassword());
            if (login_user != null) {
                String token = jwtUtil.generateToken(login_user.getUserId());
                return new ResponseEntity<>(token, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") long id) {
        User user = userRepository.findById(id);

        if (user != null) {
            // String token=jwtUtil.generateToken(user.getUserId());
            // System.out.println("token : "+token);
            return new ResponseEntity<>(user, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getartists")//C
    public ResponseEntity<List<Artist>> C4(HttpServletRequest request) {
        long user_id = jwtUtil.AuthenticateToken(request);
        try {
            List<Artist> artists = userRepository.getArtists(user_id);
            if (artists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(artists, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/users/update-subscription")
    public ResponseEntity<String> updateSubscription(HttpServletRequest request, @RequestBody Map<String, Long> payload) {
        try {
            long user_id = jwtUtil.AuthenticateToken(request);
            long subscriptionId = payload.get("subscription_id");
            System.out.println(subscriptionId);
            User user = userRepository.findById(user_id);
            if (user != null) {
                // System.out.println(user.getSubscriptionId());
                userRepository.setSubscriptionId1(subscriptionId, user_id);
                return new ResponseEntity<>("Subscription updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

