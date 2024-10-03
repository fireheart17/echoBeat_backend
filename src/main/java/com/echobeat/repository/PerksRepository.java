package com.echobeat.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Perks;

@Repository
public class PerksRepository implements PerksInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PerksRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Perks perks) {
        return jdbcTemplate.update("INSERT INTO perks (subscription_id, description) VALUES (?, ?)",
                perks.getSubscription_id(), perks.getDescription());
    }

    @Override
    public int update(Perks perks) {
        return jdbcTemplate.update("UPDATE perks SET description = ? WHERE subscription_id = ?",
                perks.getDescription(), perks.getSubscription_id());
    }

    @Override
    public int delete(long subscriptionId) {
        return jdbcTemplate.update("DELETE FROM perks WHERE subscription_id = ?", subscriptionId);
    }

    @Override
    public Perks findBySubscriptionId(long subscriptionId) {
        return jdbcTemplate.queryForObject("SELECT * FROM perks WHERE subscription_id = ?",
                new BeanPropertyRowMapper<>(Perks.class), subscriptionId);
    }
}