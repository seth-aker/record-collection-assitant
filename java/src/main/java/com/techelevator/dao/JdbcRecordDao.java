package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Record;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecordDao implements RecordDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Record getRecordById(int recordId) {
        String sql = "SELECT record_id, user_note " +
                    "FROM records" +
                    "WHERE record_id = ?";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recordId);
            if(result.next()) {
                return mapRowToRecord(result);
            } else {
                return null;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }

    public List<Record> getUserLibrary(int userId) {
        String sql = "SELECT record_id, user_note " +
                    "FROM records as r " +
                    "JOIN user_record AS ur ON r.record_id = ur.record_id " +
                    "WHERE ur.user_id = ?";

        List<Record> userLib = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()) {
                userLib.add(mapRowToRecord(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return userLib;
    }

    private Record mapRowToRecord(SqlRowSet rowSet) {
        Record record = new Record();
        record.setId(rowSet.getInt("record_id"));
        record.setUserNote(rowSet.getString("user_note"));
    return record;
    }
}
