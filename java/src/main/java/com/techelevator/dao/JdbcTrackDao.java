package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Track;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
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

    public void addTrack(Track track) {
        String sql = "INSERT INTO tracks (track_id, title, duration, track_number " +
                "VALUES (?, ?, ?, ?);";

        try {
            jdbcTemplate.update(sql, track.getTrackId(), track.getTitle(), track.getDuration(), track.getNumber());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public boolean updateTrack(Track track) {
        int id = Integer.parseInt(track.getTrackId());
        String sql = "UPDATE tracks " +
                "SET title = ?, duration = ?, track_number = ?," +
                "WHERE track_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, track.getTitle(), track.getDuration(), track.getNumber(), track.getTrackId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return true;
    }

    public int deleteTrackById(String id) {
        int numberOfRows;
        String recordTrackSql = "DELETE FROM record_track WHERE track_id = ?;";
        String sql = "DELETE FROM tracks WHERE track_id = ?;";

        try {
            jdbcTemplate.update(recordTrackSql, id);
            numberOfRows = jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
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
