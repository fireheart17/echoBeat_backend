package com.echobeat.repository;

import com.echobeat.model.Subscription;

public interface SubscriptionInterface {
    int saveSubscription(Subscription subscription);
    int updateSubscription(Subscription subscription);
    int deleteSubscription(long subscriptionId);
    Subscription findSubscriptionById(long subscriptionId);
}
