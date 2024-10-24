package com.echobeat.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
  private Long user_id;
  @JsonProperty("first_name")
  private String first_name;
  private String last_name;
  private String username;
  private String password;
  private LocalDate dob;
  private Integer age;
  private String gender;
  @JsonProperty("subscription_id")
  private Long subscription_id;
  private String subscription_end_date;

  public User() {

  }

  public User(String first_name, String last_name, String username, String password,
  LocalDate dob, Integer age, String gender, Long subscription_id, String subscription_end_date) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.username = username;
    this.password = password;
    this.dob = dob;
    this.age = age;
    this.gender = gender;
    this.subscription_id = subscription_id;
    this.subscription_end_date = subscription_end_date;
  }

  // Getters and Setters

  public Long getUserId() {
    return user_id;
  }

  public void setUserId(Long user_id) {
    this.user_id = user_id;
  }

  public String getFirstName() {
    return first_name;
  }

  public void setFirstName(String first_name) {
    this.first_name = first_name;
  }

  public String getLastName() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Long getSubscriptionId() {
    return subscription_id;
  }

  public void setSubscriptionId(Long subscription_id) {
    this.subscription_id = subscription_id;
  }

  public String getSubscriptionEndDate() {
    return subscription_end_date;
  }

  public void setSubscriptionEndDate(String subscription_end_date) {
    this.subscription_end_date = subscription_end_date;
  }
}
