package com.techelevator.dao;

import com.techelevator.model.Artist;
import com.techelevator.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcGenreDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcGenreDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public Genre mapRowToGenre(SqlRowSet rowSet) {
        Genre genre = new Genre();
        genre.setName(rowSet.getString("genre_name"));
        return genre;
    }

}
