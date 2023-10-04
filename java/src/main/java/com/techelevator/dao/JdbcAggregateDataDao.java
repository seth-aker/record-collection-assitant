package com.techelevator.dao;

import com.techelevator.model.Record;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAggregateDataDao implements AggregateDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAggregateDataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int getTotalNumberOfUsers() {
        int numberOfUsers = 0;
        String sql = "SELECT COUNT (*) FROM users;";
        try {
            SqlRowSet results = jdbcTemplate.;
            if (results.next()) {
                numberOfUsers = results;
            }
        }
    }



@Override
public Record getMostPopularRecord() {
    Record record = null;
    String sql = "SELECT record_id, COUNT(*) AS popularity_count " +
            "FROM collection_record " +
            "GROUP BY record_id " +
            "ORDER BY popularity_count DESC " +
            "LIMIT 1;";
    SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
    try {
        if (result.next()) {
            record = mapRowToRecord(result);
        }
    }
}

    private Record mapRowToRecord(SqlRowSet rowSet) {
        Record record = new Record();
        record.setId(rowSet.getString("record_id"));
        record.setTitle(rowSet.getString("record_title"));
        record.setThumb(rowSet.getString("record_image"));
        record.setArtist(rowSet.getString("record_artist"));
//        if(rowSet.getString("record_condition") != null) {
//            record.setCondition(rowSet.getString("record_condition"));
//        }
//        if(rowSet.getString("user_note") != null) {
//            record.setUserNote(rowSet.getString("user_note"));
//        }
        return record;
    }


        }
}
