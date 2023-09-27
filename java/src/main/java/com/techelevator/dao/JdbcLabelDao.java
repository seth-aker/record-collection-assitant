package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Label;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
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

    public boolean updateLabel(Label label) {
        String sql = "UPDATE labels " +
                "SET label_name = ?," +
                "WHERE label_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, label.getName(), label.getId());

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

    public void addLabel(Label label) {
        String sql = "INSERT INTO labels (label_name) " +
                "VALUES (?);";

        try {
            jdbcTemplate.update(sql, label.getName());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public int deleteLabelById(int id) {
        int numberOfRows;
        String recordLabelSql = "DELETE FROM record_label WHERE label_id = ?;";
        String sql = "DELETE FROM labels WHERE label_id = ?;";

        try {
            jdbcTemplate.update(recordLabelSql, id);
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

    public Label mapRowToLabel(SqlRowSet rowSet) {
        Label label = new Label();
        label. setName(rowSet.getString("genre_name"));
        return label;
    }

}
