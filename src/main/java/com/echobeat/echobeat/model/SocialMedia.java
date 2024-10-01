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
@Table(name = "social_medias")
public class SocialMedia {
    @Id
    private String socialMediaType;
    @Id
    private long artistId;
    @Column(name = "social_media_handle", nullable = false)
    private String socialMediaHandle;
}
