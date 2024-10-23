package com.echobeat.controller;

import java.util.List;

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
import com.echobeat.model.Track;
import com.echobeat.repository.RankingInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RankingController {

    @Autowired
    RankingInterface rankingRepository;

    
    @PostMapping("/rankings")
    public ResponseEntity<String> createRanking(@RequestBody Ranking ranking) {
        try {
            rankingRepository.save(ranking);
            return new ResponseEntity<>("Ranking was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rankings/{chartid}")
    public ResponseEntity<List<Track>> getRankingByChartId(@PathVariable("chartid") long chartid) {
        List<Track> rankings = rankingRepository.findByChartId(chartid);

        if (rankings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rankings, HttpStatus.OK);
        }
    }

    @DeleteMapping("/rankings/{chartid}/{trackid}")
    public ResponseEntity<String> deleteRankingByTrack(@PathVariable("chartid") long chartid, @PathVariable("trackid") String trackid) {
        try {
            rankingRepository.deleteByTrack(trackid, chartid);
            return new ResponseEntity<>("Ranking deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting ranking.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/rankings/{chartid}/{rank}")
    public ResponseEntity<String> deleteRankingByRank(@PathVariable("chartid") long chartid, @PathVariable("rank") int rank) {
        try {
            rankingRepository.deleteByRank(rank, chartid);
            return new ResponseEntity<>("Ranking deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting ranking.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
