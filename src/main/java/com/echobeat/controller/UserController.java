package com.echobeat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      String token=jwtUtil.generateToken(user.getUserId());
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
          user.getPassword(),
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
}

// @PutMapping("/tutorials/{id}")
// public ResponseEntity<String> updateTutorial(@PathVariable("id") long id,
// @RequestBody Tutorial tutorial) {
// Tutorial _tutorial = tutorialRepository.findById(id);

// if (_tutorial != null) {
// _tutorial.setId(id);
// _tutorial.setTitle(tutorial.getTitle());
// _tutorial.setDescription(tutorial.getDescription());
// _tutorial.setPublished(tutorial.isPublished());

// tutorialRepository.update(_tutorial);
// return new ResponseEntity<>("Tutorial was updated successfully.",
// HttpStatus.OK);
// } else {
// return new ResponseEntity<>("Cannot find Tutorial with id=" + id,
// HttpStatus.NOT_FOUND);
// }
// }

// @DeleteMapping("/tutorials/{id}")
// public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
// try {
// int result = tutorialRepository.deleteById(id);
// if (result == 0) {
// return new ResponseEntity<>("Cannot find Tutorial with id=" + id,
// HttpStatus.OK);
// }
// return new ResponseEntity<>("Tutorial was deleted successfully.",
// HttpStatus.OK);
// } catch (Exception e) {
// return new ResponseEntity<>("Cannot delete tutorial.",
// HttpStatus.INTERNAL_SERVER_ERROR);
// }
// }

// @DeleteMapping("/tutorials")
// public ResponseEntity<String> deleteAllTutorials() {
// try {
// int numRows = tutorialRepository.deleteAll();
// return new ResponseEntity<>("Deleted " + numRows + " Tutorial(s)
// successfully.", HttpStatus.OK);
// } catch (Exception e) {
// return new ResponseEntity<>("Cannot delete tutorials.",
// HttpStatus.INTERNAL_SERVER_ERROR);
// }

// }

// @GetMapping("/tutorials/published")
// public ResponseEntity<List<Tutorial>> findByPublished() {
// try {
// List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

// if (tutorials.isEmpty()) {
// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// }
// return new ResponseEntity<>(tutorials, HttpStatus.OK);
// } catch (Exception e) {
// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// }
// }
