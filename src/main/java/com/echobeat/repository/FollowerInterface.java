package com.echobeat.repository;

import com.echobeat.model.Follower;

public interface FollowerInterface {
    int addFollower(Follower follower);
    int removeFollower(long artist_id, long user_id);
}
