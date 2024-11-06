package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.Follower;
import com.echobeat.model.User;

public interface FollowerInterface {
    int addFollower(Follower follower);
    int removeFollower(long artist_id, long user_id);
    int addFollowerToken(long artist_id, long user_id);
    boolean checkFollowerToken(long artist_id, long user_id);
    List<User> getFollowers(long artist_id);
}
