package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.Perks;

public interface PerksInterface {
    int save(Perks perks);

    int update(Perks perks);

    int delete(long subscriptionId);

    List<String> findBySubscriptionId(long subscriptionId);
}