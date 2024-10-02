package com.echobeat.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.User;

@Repository
public class UserRepository implements UserInterface {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(User user) {
    String sql = "INSERT INTO users (first_name, last_name, username, password, dob, age, gender, subscription_id, subscription_end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    return jdbcTemplate.update(sql,
        user.getFirstName(),
        user.getLastName(),
        user.getUsername(),
        user.getPassword(),
        user.getDob(),
        user.getAge(),
        user.getGender(),
        user.getSubscriptionId(),
        user.getSubscriptionEndDate());
  }

  @Override
  public int update(User user) {
    return 0;
  }

  @Override
  public User findById(Long user_id) {
    System.out.println(user_id);
    try {
      User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE user_id=?",
          BeanPropertyRowMapper.newInstance(User.class), user_id);

      // System.out.println(user);
      return user;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(Long user_id) {
    return jdbcTemplate.update("DELETE FROM users WHERE user_id=?", user_id);
  }

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query("SELECT * from users", BeanPropertyRowMapper.newInstance(User.class));
  }

  @Override
  public User findByCredentials(String username, String password) {
    try {
      User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE username=? AND password=?",
          BeanPropertyRowMapper.newInstance(User.class), username, password);

      return user;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from users");
  }
}
