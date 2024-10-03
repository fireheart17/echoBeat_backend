package com.echobeat.repository;

import com.echobeat.model.Ranking;


public interface RankingInterface {
    Ranking save(Ranking ranking);
    Ranking findById(long rankId);
    Ranking update(Ranking ranking);
    Ranking deleteById(long rankId);
}

