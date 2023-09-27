package com.techelevator.dao;

import com.techelevator.model.Artist;
import com.techelevator.model.Track;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcTrackDao implements TrackDao{


    private JdbcTemplate jdbcTemplate;

    public JdbcTrackDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Track mapRowToTrack(SqlRowSet rowSet) {
        Track track = new Track();
        track.setTrackId(rowSet.getString("track_id"));
        track.setTitle(rowSet.getString("title"));
        track.setDuration(String.valueOf(rowSet.getInt("duration")));
        track.setNumber(String.valueOf(rowSet.getInt("track_number")));
        return track;
    }
}
