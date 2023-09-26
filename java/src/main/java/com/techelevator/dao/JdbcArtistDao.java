package com.techelevator.dao;

import com.techelevator.model.Artist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcArtistDao {

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
                return
            }
        }
    }

    public Artist mapRowToArtist(SqlRowSet rowSet) {
        Artist artist = new Artist();
        artist.setArtistId(rowSet.getString("artist_id"));
        artist.setName(rowSet.getString("artist_name"));

    }

}
