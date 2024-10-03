package com.echobeat.controller;

import java.time.LocalTime;
import java.util.ArrayList;
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

import com.echobeat.model.Perks;
import com.echobeat.repository.PerksRepository;

@CrossOrigin(origins = "http://localhost:8081") // Adjust origin as needed
@RestController
@RequestMapping("/api/perks") // Adjust path based on your API design
public class PerksController {

    @Autowired
    private PerksRepository perksRepository;

    @GetMapping("/get/{subscriptionId}")
    public ResponseEntity<Perks> getPerkBySubscriptionId(@PathVariable("subscriptionId") long subscriptionId) {
        try {
            Perks perk = perksRepository.findBySubscriptionId(subscriptionId);

            if (perk != null) {
                return new ResponseEntity<>(perk, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> savePerk(@RequestBody Perks perk) {
        try {
            perksRepository.save(perk);
            return new ResponseEntity<>("Perk saved successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{subscriptionId}")
    public ResponseEntity<String> updatePerk(@PathVariable("subscriptionId") long subscriptionId,
            @RequestBody Perks updatedPerk) {
        try {
            Perks existingPerk = perksRepository.findBySubscriptionId(subscriptionId);

            if (existingPerk != null) {
                existingPerk.setDescription(updatedPerk.getDescription());
                perksRepository.update(existingPerk);
                return new ResponseEntity<>("Perk updated successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Perk not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{subscriptionId}")
    public ResponseEntity<String> deletePerk(@PathVariable("subscriptionId") long subscriptionId) {
        try {
            int result = perksRepository.delete(subscriptionId);

            if (result == 0) {
                return new ResponseEntity<>("Perk not found.", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>("Perk deleted successfully.", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}