package com.echobeat.echobeat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rankings")
public class Ranking {
    @Id
    private long chartId;
    @Id
    private long rankId;
    @Column(name="rank",nullable=false)
    private long rank;
}
