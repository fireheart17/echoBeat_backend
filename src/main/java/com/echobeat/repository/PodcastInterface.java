package com.echobeat.repository;
import com.echobeat.model.Podcast;
import java.util.List;

public interface PodcastInterface {
    int save(Podcast podcast);  
    Podcast update(Podcast podcast); 
    Podcast deleteById(long podcastId); 
    Podcast findById(long podcastId);
    List<Podcast> search(String keyword);
    
}

