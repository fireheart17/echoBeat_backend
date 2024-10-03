package com.echobeat.repository;

import com.echobeat.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionRepository implements SubscriptionInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SUBSCRIPTION = "INSERT INTO subscriptions (title, price, duration) VALUES (?, ?, ?)";
    private final String UPDATE_SUBSCRIPTION = "UPDATE subscriptions SET title = ?, price = ?, duration = ? WHERE subscription_id = ?";
    private final String DELETE_SUBSCRIPTION = "DELETE FROM subscriptions WHERE subscription_id = ?";
    private final String SELECT_SUBSCRIPTION = "SELECT * FROM subscriptions WHERE subscription_id = ?";

    @Override
    public int saveSubscription(Subscription subscription) {
        return jdbcTemplate.update(INSERT_SUBSCRIPTION, subscription.getTitle(), subscription.getPrice(), subscription.getDuration());
    }

    @Override
    public int updateSubscription(Subscription subscription) {
        return jdbcTemplate.update(UPDATE_SUBSCRIPTION, subscription.getTitle(), subscription.getPrice(), subscription.getDuration(), subscription.getSubscription_id());
    }

    @Override
    public int deleteSubscription(long subscriptionId) {
        return jdbcTemplate.update(DELETE_SUBSCRIPTION, subscriptionId);
    }

    @Override
    public Subscription findSubscriptionById(long subscriptionId) {
        return jdbcTemplate.queryForObject(SELECT_SUBSCRIPTION, new BeanPropertyRowMapper<>(Subscription.class), subscriptionId);
    }
}
