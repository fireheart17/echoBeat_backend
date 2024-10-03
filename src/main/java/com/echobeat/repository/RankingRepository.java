package com.echobeat.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Ranking;


@Repository
public class RankingRepository implements RankingInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find Ranking by ID
    @Override
    public Ranking findById(long id) {
        String sql = "SELECT * FROM Ranking WHERE rank_id = ?";
        return jdbcTemplate.queryForObject(
            sql, 
            new Object[]{id}, 
            new BeanPropertyRowMapper<>(Ranking.class)
        );
    }

    // Save Ranking (Insert) and return the saved Ranking
    @Override
    public Ranking save(Ranking ranking) {
        String sql = "INSERT INTO Ranking (chart_id, rank_val) VALUES (?, ?)"; // Updated to rank_val
        jdbcTemplate.update(sql, ranking.getChart_id(), ranking.getRank_val()); // Updated to rank_val

        // Fetch the last inserted rank_id
        String getLastIdSql = "SELECT LAST_INSERT_ID()";
        Long newRankId = jdbcTemplate.queryForObject(getLastIdSql, Long.class);

        // Return the inserted Ranking
        return findById(newRankId);
    }

    // Update Ranking and return the updated Ranking
    @Override
    public Ranking update(Ranking ranking) {
        String sql = "UPDATE Ranking SET chart_id = ?, rank_val = ? WHERE rank_id = ?"; // Updated to rank_val
        jdbcTemplate.update(sql, ranking.getChart_id(), ranking.getRank_val(), ranking.getRank_id()); // Updated to rank_val
        return findById(ranking.getRank_id());
    }

    // Delete Ranking by ID and return the deleted Ranking
    @Override
    public Ranking deleteById(long id) {
        Ranking ranking = findById(id);  // Get the ranking before deleting
        String sql = "DELETE FROM Ranking WHERE rank_id = ?";
        jdbcTemplate.update(sql, id);
        return ranking;
    }
}
