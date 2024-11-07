package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.Artist;
import com.echobeat.model.User;

public interface UserInterface {
  int save(User book);

  int update(User book);

  User findById(Long id);

  int deleteById(Long id);

  List<User> findAll();

  User findByCredentials(String username, String password);

  int deleteAll();

  List<Artist> getArtists(long user_id);
  
  void setSubscriptionId1(Long subscription_id,Long user_id);
  
}
