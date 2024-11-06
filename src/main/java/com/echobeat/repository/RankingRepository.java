package com.echobeat.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Ranking;
import com.echobeat.model.Track;


@Repository
public class RankingRepository implements RankingInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Ranking save(Ranking ranking) {
        String sql = "INSERT INTO rankings (track_id, chart_id, rank_val) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, ranking.getTrack_id(), ranking.getChart_id(), ranking.getRank_val());
        return ranking;
    }

    @Override
    public List<Track> findByChartId(long chartId) {
        String sql = "SELECT t.* FROM tracks t JOIN rankings r ON t.track_id = r.track_id WHERE r.chart_id = ? ORDER BY r.rank_val ASC;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class), chartId);
    }

    @Override
    public Ranking update(Ranking ranking) {
        String sql = "UPDATE rankings SET rank_val = ? WHERE track_id = ? AND chart_id = ?";
        jdbcTemplate.update(sql, ranking.getRank_val(), ranking.getTrack_id(), ranking.getChart_id());
        return ranking;
    }

    @Override
    public Ranking deleteByRank(long rankVal, long chartId) {
        String sql = "DELETE FROM rankings WHERE rank_val = ? AND chart_id = ?";
        jdbcTemplate.update(sql, rankVal, chartId);
        return null;
    }

    @Override
    public Ranking deleteByTrack(String trackId, long chartId) {
        String sql = "DELETE FROM rankings WHERE track_id = ? AND chart_id = ?";
        jdbcTemplate.update(sql, trackId, chartId);
        return null;
    }
}


