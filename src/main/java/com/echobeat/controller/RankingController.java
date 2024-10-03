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

import com.echobeat.model.Ranking;
import com.echobeat.repository.RankingInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RankingController {

    @Autowired
    RankingInterface rankingRepository;

    

    @GetMapping("/rankings/{id}")
    public ResponseEntity<Ranking> getRankingById(@PathVariable("id") long id) {
        Ranking ranking = rankingRepository.findById(id);

        if (ranking != null) {
            return new ResponseEntity<>(ranking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/rankings")
    public ResponseEntity<String> createRanking(@RequestBody Ranking ranking) {
        try {
            Ranking savedRanking = rankingRepository.save(new Ranking(ranking.getChart_id(), ranking.getRank_val())); // Updated to rank_val
            return new ResponseEntity<>("Ranking was created successfully with ID: " + savedRanking.getRank_id(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/rankings/{id}")
    public ResponseEntity<String> deleteRanking(@PathVariable("id") long id) {
        try {
            Ranking deletedRanking = rankingRepository.deleteById(id);
            if (deletedRanking != null) {
                return new ResponseEntity<>("Ranking was deleted successfully: " + deletedRanking.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cannot find Ranking with id=" + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete ranking.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
