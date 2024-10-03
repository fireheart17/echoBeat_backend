package com.echobeat.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.SocialMedia;


@Repository
public class SocialMediaRepository implements SocialMediaInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO SocialMedia (artist_id, socialmediatype, socialmediahandle) VALUES (?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE SocialMedia SET socialmediahandle = ? WHERE artist_id = ? AND socialmediatype = ?";
    private final String DELETE_SQL = "DELETE FROM SocialMedia WHERE artist_id = ? AND socialmediatype = ?";
    private final String FIND_BY_ID_SQL = "SELECT * FROM SocialMedia WHERE artist_id = ? AND socialmediatype = ?";

    @Override
    public SocialMedia save(SocialMedia socialMedia) {
        jdbcTemplate.update(INSERT_SQL, socialMedia.getArtist_id(), socialMedia.getSocialmediatype(), socialMedia.getSocialmediahandle());
        return socialMedia; // Return the saved SocialMedia object
    }

    @Override
    public SocialMedia update(SocialMedia socialMedia) {
        jdbcTemplate.update(UPDATE_SQL, socialMedia.getSocialmediahandle(), socialMedia.getArtist_id(), socialMedia.getSocialmediatype());
        return socialMedia; // Return the updated SocialMedia object
    }

    @Override
    public SocialMedia delete(long artistId, String socialMediaType) {
        SocialMedia socialMediaToDelete = findById(artistId, socialMediaType);
        if (socialMediaToDelete != null) {
            jdbcTemplate.update(DELETE_SQL, artistId, socialMediaType);
        }
        return socialMediaToDelete; // Return the deleted SocialMedia object
    }

    @Override
    public SocialMedia findById(long artistId, String socialMediaType) {
        return jdbcTemplate.queryForObject(FIND_BY_ID_SQL, new BeanPropertyRowMapper<>(SocialMedia.class), artistId, socialMediaType);
    }
}
