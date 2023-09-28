package com.techelevator.dao;

import com.techelevator.model.spotifyAPImodels.Tracks;

import javax.sound.midi.Track;

public interface TrackDao {
    Tracks getTrackById(String id);
    void addTrack(Track track);
    boolean updateTrack(Track track);
    int deleteTrackById(String id);
}
