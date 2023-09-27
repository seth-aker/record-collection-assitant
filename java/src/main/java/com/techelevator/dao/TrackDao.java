package com.techelevator.dao;

import com.techelevator.model.Track;

public interface TrackDao {
    Track getTrackById(String id);
    void addTrack(Track track);
    boolean updateTrack(Track track);
    int deleteTrackById(String id);
}
