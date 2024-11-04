package com.echobeat.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Album;
import com.echobeat.model.Artist;
import com.echobeat.model.Track;

@Repository
public class ArtistRepository implements ArtistInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveArtist(Artist artist) {
        System.out.println(artist.getFirst_name());
        String sql = "INSERT INTO artists (first_name, last_name, password, global_rank, country, about, follower_count) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                artist.getFirst_name(),
                artist.getLast_name(),
                artist.getPassword(),
                artist.getGlobal_rank(),
                artist.getCountry(),
                artist.getAbout(),
                artist.getFollower_count());
    }

    @Override
    public Artist updateArtist(Artist artist) {
        String sql = "UPDATE artists SET first_name = ?, last_name = ?, password = ?, global_rank = ?, country = ?, about = ?, follower_count = ? "
                +
                "WHERE artist_id = ?";
        jdbcTemplate.update(sql,
                artist.getFirst_name(),
                artist.getLast_name(),
                artist.getPassword(),
                artist.getGlobal_rank(),
                artist.getCountry(),
                artist.getAbout(),
                artist.getFollower_count(),
                artist.getArtist_id());

        // Return the updated artist
        return findArtistById(artist.getArtist_id());
    }

    @Override
    public Artist deleteArtist(long artistId) {
        // Find the artist before deletion
        Artist artist = findArtistById(artistId);
        if (artist != null) {
            String sql = "DELETE FROM artists WHERE artist_id = ?";
            jdbcTemplate.update(sql, artistId);
        }
        return artist; // Return the deleted artist
    }

    @Override
    public Artist findArtistById(long artistId) {
        String sql = "SELECT * FROM artists WHERE artist_id = ?";
        RowMapper<Artist> rowMapper = BeanPropertyRowMapper.newInstance(Artist.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, artistId);
    }
    
    @Override
    public List<Track>getTracksByArtistId(long id){
        String sql = "SELECT * from tracks where track_id in (SELECT track_id FROM track_creators WHERE artist_id=?)";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class), id);
    }

    @Override
    public List<Album>getAlbumsByArtistId(long id){
        String sql = "SELECT * from albums where album_id in (SELECT album_id FROM created_album WHERE artist_id=?)";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Album.class),id);
    }

}
