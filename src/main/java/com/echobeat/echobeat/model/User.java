package com.echobeat.echobeat.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "date_of_birth",nullable = true)
    private LocalTime dob;
    @Column(name = "age",nullable = false)
    private int age;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "subscription_id",nullable = true)
    private long  subscriptionId;
    @Column(name = "subscription_end_date",nullable = false)
    private String subscriptionEndDate;
}
