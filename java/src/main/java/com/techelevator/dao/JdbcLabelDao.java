package com.techelevator.dao;

import com.techelevator.model.Genre;
import com.techelevator.model.Label;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcLabelDao implements LabelDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLabelDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Label mapRowToLabel(SqlRowSet rowSet) {
        Label label = new Label();
        label. setName(rowSet.getString("genre_name"));
        return label;
    }

}
