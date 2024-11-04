package com.echobeat.repository;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> findBySubscriptionId(long subscriptionId) {
        List<Perks> result=jdbcTemplate.query("SELECT * FROM perks WHERE subscription_id = ?",
        new BeanPropertyRowMapper<>(Perks.class), subscriptionId);
        List<String> ls=new ArrayList<>();
        for (Perks item : result) {
            ls.add(item.getDescription());
        }
        return ls;
    }
}