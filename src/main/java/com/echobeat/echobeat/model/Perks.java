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
@Table(name = "perks")
public class Perks {
    @Id
    private long subscriptionId;
    @Column(name = "description", nullable = false)
    private String description;
}
