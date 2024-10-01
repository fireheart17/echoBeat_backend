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
@Table(name = "podcast_creators")
public class PodcastCreator {
    @Id
    private long trackId;
    @Id
    private long artistId;
}
