package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcRecordDao implements RecordDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Record mapRowToRecord(SqlRowSet rowSet) {
        Record record = new Record();
        record.setId(rowSet.getInt("record_id"));
        record.setArtist(rowSet.getString("artist"));
        record.setAlbumName(rowSet.getString("album_name"));
        record.setNote(rowSet.getString("note"));
        record.setYearReleased(rowSet.getString("year_released"));
    return record;
    }
}
