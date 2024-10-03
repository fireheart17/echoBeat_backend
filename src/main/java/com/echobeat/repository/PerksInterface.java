package com.echobeat.repository;

import com.echobeat.model.Perks;

public interface PerksInterface {
    int save(Perks perks);

    int update(Perks perks);

    int delete(long subscriptionId);

    Perks findBySubscriptionId(long subscriptionId);
}