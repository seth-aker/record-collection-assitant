package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Artist;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcArtistDao implements ArtistDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcArtistDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Artist getArtistById (String id) {
        String sql = "SELECT artist_id, artist_name " +
                     "FROM artists WHERE artist_id = ?";
        String sql2 = "SELECT genre_name " +
                      "FROM artist_genre"

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
            if(result.next()) {
                return mapRowToArtist(result);
            } else {
                throw new DaoException("Could not find artist in database.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }

    public List<Artist> getRecordArtists(String recordId ) {
        String sql = "SELECT ra.artist_id, a.artist_name " +
                " FROM record_artist AS ra " +
                "JOIN artists AS a ON ra.artist_id = a.artist_id " +
                "WHERE ra.record_id = ?";
        List<Artist> artists = new ArrayList<>();

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recordId);
            while (results.next()) {
                artists.add(mapRowToArtist(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return artists;
    }

    public Artist mapRowToArtist(SqlRowSet rowSet) {
        Artist artist = new Artist();
        artist.setArtistId(rowSet.getString("artist_id"));
        artist.setName(rowSet.getString("artist_name"));
        return artist;
    }

}
