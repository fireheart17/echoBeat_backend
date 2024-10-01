package com.echobeat.echobeat.model;

import org.hibernate.annotations.ColumnDefault;

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
@Table(name = "podcasts")
public class Podcast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long podcastId;
    @Column(name = "podcast_name", nullable = false)
    private String podcastName;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "lyrics", nullable = true)
    private String lyrics;
    @Column(name = "duration", nullable = false)
    private int duration;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "like_count", nullable = false)
    @ColumnDefault("0")
    private int likeCount;
    @Column(name = "listen_count", nullable = false)
    @ColumnDefault("0")
    private int listenCount;
}
