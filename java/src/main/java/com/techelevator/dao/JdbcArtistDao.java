package com.techelevator.dao;

import com.techelevator.model.Artist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcArtistDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcArtistDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Artist getArtistById (String id) {
        String sql = "SELECT "
    }

}
