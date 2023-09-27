package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Artist;
import com.techelevator.model.Track;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcTrackDao implements TrackDao{


    private JdbcTemplate jdbcTemplate;

    public JdbcTrackDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Track getTrackById(String id){
        String sql = "SELECT track_id, title, duration, track_number " +
                     "FROM tracks " +
                     "WHERE track_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                return mapRowToTrack(results);
            } else {
                return null;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
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
