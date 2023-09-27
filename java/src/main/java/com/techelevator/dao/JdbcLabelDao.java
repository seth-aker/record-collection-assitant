package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Genre;
import com.techelevator.model.Label;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcLabelDao implements LabelDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLabelDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Label getLabelById(int id) {
        String sql = "SELECT label_id, label_name " +
                     "FROM labels " +
                     "WHERE label_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if(results.next()) {
                return mapRowToLabel(results);
            } else {
                return null;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }


    public Label mapRowToLabel(SqlRowSet rowSet) {
        Label label = new Label();
        label. setName(rowSet.getString("genre_name"));
        return label;
    }

}
