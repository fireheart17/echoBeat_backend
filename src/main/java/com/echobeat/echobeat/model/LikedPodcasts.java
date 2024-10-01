package com.echobeat.echobeat.model;

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
@Table(name = "liked_podcasts")
public class LikedPodcasts {
    @Id
    private long userId;
    @Id
    private long podcastId;
}
