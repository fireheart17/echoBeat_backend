package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.User;

public interface UserInterface {
  int save(User book);

  int update(User book);

  User findById(Long id);

  int deleteById(Long id);

  List<User> findAll();

  User findByCredentials(String username, String password);

  int deleteAll();

  
}
