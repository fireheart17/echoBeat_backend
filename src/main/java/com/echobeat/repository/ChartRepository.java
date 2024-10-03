package com.echobeat.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Chart;

@Repository
public class ChartRepository implements ChartInterface {

    private final JdbcTemplate jdbcTemplate;

    public ChartRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Chart chart) {
        String sql = "INSERT INTO charts (chart_type) VALUES (?)";
        return jdbcTemplate.update(sql, chart.getChart_type());
    }

    @Override
    public int update(Chart chart) {
        String sql = "UPDATE charts SET chart_type = ? WHERE chart_id = ?";
        return jdbcTemplate.update(sql, chart.getChart_type(), chart.getChart_id());
    }

    @Override
    public int deleteById(long chartId) {
        String sql = "DELETE FROM charts WHERE chart_id = ?";
        return jdbcTemplate.update(sql, chartId);
    }

    @Override
    public Chart findById(long chartId) {
        String sql = "SELECT * FROM charts WHERE chart_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Chart.class), chartId);
    }

    @Override
    public List<Chart> findAll() {
        String sql = "SELECT * FROM charts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Chart.class));
    }
}
