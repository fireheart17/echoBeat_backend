
package com.echobeat.repository;
import java.util.List;
import com.echobeat.model.Ranking;
import com.echobeat.model.Track;

public interface RankingInterface {
    Ranking save(Ranking ranking);
    List<Track> findByChartId(long chart_id);
    Ranking update(Ranking ranking);
    Ranking deleteByRank(long rank_val, long chartId);
    Ranking deleteByTrack(String trackId, long chartId);
}

