package com.echobeat.repository;

import com.echobeat.model.SocialMedia;

public interface SocialMediaInterface {
    SocialMedia save(SocialMedia socialMedia);
    SocialMedia update(SocialMedia socialMedia);
    SocialMedia delete(long artistId, String socialMediaType);
    SocialMedia findById(long artistId, String socialMediaType);
}

