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

import com.echobeat.model.Subscription;
import com.echobeat.repository.SubscriptionInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SubscriptionController {

    @Autowired
    private SubscriptionInterface subscriptionRepository;

    @GetMapping("/subscriptions/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable("id") long id) {
        Subscription subscription = subscriptionRepository.findSubscriptionById(id);

        if (subscription != null) {
            return new ResponseEntity<>(subscription, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<String> createSubscription(@RequestBody Subscription subscription) {
        try {
            subscriptionRepository.saveSubscription(new Subscription(
                subscription.getSubscription_id(),  // You may want to change this based on your logic
                subscription.getTitle(),
                subscription.getPrice(),
                subscription.getDuration()
            ));
            return new ResponseEntity<>("Subscription created.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/subscriptions/{id}")
    public ResponseEntity<String> updateSubscription(@PathVariable("id") long id, @RequestBody Subscription subscription) {
        Subscription existingSubscription = subscriptionRepository.findSubscriptionById(id);

        if (existingSubscription != null) {
            existingSubscription.setTitle(subscription.getTitle());
            existingSubscription.setPrice(subscription.getPrice());
            existingSubscription.setDuration(subscription.getDuration());

            subscriptionRepository.updateSubscription(existingSubscription);
            return new ResponseEntity<>("Subscription was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find subscription with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/subscriptions/{id}")
    public ResponseEntity<String> deleteSubscription(@PathVariable("id") long id) {
        int deletedCount = subscriptionRepository.deleteSubscription(id);
        if (deletedCount > 0) {
            return new ResponseEntity<>("Subscription was deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find subscription with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
}
