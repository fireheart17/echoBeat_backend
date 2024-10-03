package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.Chart;

public interface ChartInterface {
    int save(Chart chart);
    int update(Chart chart);
    int deleteById(long chartId);
    Chart findById(long chartId);
    List<Chart> findAll();
}
