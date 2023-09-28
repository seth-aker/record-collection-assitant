package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Record;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecordDao implements RecordDao {

    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    public JdbcRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Record getRecordById(String recordId) {

        String sql = "SELECT r.record_id, r.record_title " +
                    "FROM records " +
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
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Record id does not exist");
        }
    }

    public List<Record> getUserLibrary(int userId) {
        String sql = "SELECT r.record_id, r.record_title, ur.user_note " +
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

    public String getRecordNote(String recordId, Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());
        String sql = "SELECT user_note FROM user_record WHERE user_id = ? AND record_id = ?;";
        String note = "";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, recordId);
            if (results.next()) {
                note = results.getString("user_note");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return note;
    }

    public boolean updateRecordNote(String recordId, int userId , String note) {
        String sql = "UPDATE user_record SET user_note = ? WHERE record_id = ? AND user_id = ?;";

        try {
            int numberOfRows = this.jdbcTemplate.update(sql, note, recordId, userId);

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

    public boolean createRecord(Record record) {
        String sql = "INSERT INTO records (record_id, record_title) " +
                "VALUES (?, ?) ";
        try {
            return jdbcTemplate.update(sql, record.getId(), record.getTitle()) == 1;

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public boolean addRecordToUserLib(Record record, int userId) {
        String sql = "INSERT INTO user_record (record_id, user_id, user_note " +
                "VALUES (?, ?, ?);";

        try {
            return jdbcTemplate.update(sql, record.getId(), userId, record.getUserNote()) == 1;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public boolean removeRecordFromUserLib(Record record, int userId) {
        String sql = "DELETE FROM user_record " +
                "WHERE user_id = ? AND record_id = ?;";

        try {
            return jdbcTemplate.update(sql, userId, record.getId()) == 1;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }


    private Record mapRowToRecord(SqlRowSet rowSet) {
        Record record = new Record();
        record.setId(rowSet.getString("record_id"));
        record.setTitle(rowSet.getString("record_title"));
        if(rowSet.getString("user_note") != null) {
            record.setUserNote(rowSet.getString("user_note"));
        }
    return record;
    }
}
