package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Artist;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
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

    public List<Artist> getRecordArtists(String recordId) {
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

    public boolean updateArtist(Artist artist) {
        int id = Integer.parseInt(artist.getArtistId());
        String sql = "UPDATE artists " +
                     "SET artist_name = ?," +
                     "WHERE artist_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, artist.getName(), id);

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

    public void addArtist(Artist artist) {
        String sql = "INSERT INTO artists (artist_id, artist_name) " +
                     "VALUES (?, ?);";

        try {
            jdbcTemplate.update(sql, artist.getArtistId(), artist.getName());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public int deleteArtistById(int id) {
        int numberOfRows;
        String artistGenreSql = "DELETE FROM artist_genre WHERE artist_id = ?;";
        String sql = "DELETE FROM artists WHERE artist_id = ?;";

        try {
            jdbcTemplate.update(artistGenreSql, id);
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

    public Artist mapRowToArtist(SqlRowSet rowSet) {
        Artist artist = new Artist();
        artist.setArtistId(rowSet.getString("artist_id"));
        artist.setName(rowSet.getString("artist_name"));
        return artist;
    }

}
