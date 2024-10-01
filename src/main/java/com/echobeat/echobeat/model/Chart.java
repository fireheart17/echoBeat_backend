package com.echobeat.echobeat.model;

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
@Table(name = "charts")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chartId;
    @Column(name = "chart_type", nullable = false)
    private String chartType;
}
