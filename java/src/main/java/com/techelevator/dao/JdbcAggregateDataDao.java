package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.AggregateDataDTO;
import com.techelevator.model.Collection;
import com.techelevator.model.Record;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAggregateDataDao implements AggregateDao{

    private final JdbcTemplate jdbcTemplate;

    private UserDao userDao;

    public JdbcAggregateDataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int getTotalNumberOfUsers() {
        int numberOfUsers = 0;
        String sql = "SELECT COUNT(*) as user_count FROM users;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if (results.next()) {
                numberOfUsers = results.getInt("user_count");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Bad sql grammar dude");
        }
        return numberOfUsers;
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
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (BadSqlGrammarException e) {
        throw new DaoException("There is no most popular record");
    }
    return record;
}

    @Override
    public int getTotalNumberOfRecord() {
       int recordCount = 0;
        String sql = "SELECT COUNT(*) AS total_records FROM records;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        try {
            if (result.next()) {
              recordCount = result.getInt("total_records");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Cannot get a total record number, bad sql grammar");
        }
        return recordCount;
    }

        @Override
        public int getTotalNumberOfCollections(){
        int numberOfCollections = 0;
        String sql = "SELECT COUNT(*) AS total_collections FROM collections;";
    SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
    try {
        if (result.next()) {
           numberOfCollections = result.getInt("total_collections");
        }
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (BadSqlGrammarException e) {
        throw new DaoException("Cannot get a total number, bad sql grammar");
    }
    return numberOfCollections;
}

@Override
public int getTotalPremiumUsers(){
        int premiumUserCount = 0;
        String sql = "SELECT COUNT(*) AS total_premium_users FROM users WHERE is_premium = true;";
    SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
    try {
        if (result.next()) {
           premiumUserCount = result.getInt("total_premium_users");
        }
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (BadSqlGrammarException e) {
        throw new DaoException("Cannot get a total number, bad sql grammar");
    }
    return premiumUserCount;
}


@Override
public int getAverageNumberOfRecordsInCollections(){
        int avgNumberOfRecord = 0;
    String sql = "SELECT AVG(record_count) AS avg_records_per_collection FROM " +
            "(SELECT collection_id, COUNT(*) AS record_count " +
             "FROM collection_record GROUP BY collection_id) AS subquery;";
    SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
    try {
        if (result.next()) {
            avgNumberOfRecord = result.getInt("subquery");
        }
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (BadSqlGrammarException e) {
        throw new DaoException("Cannot get a total number, bad sql grammar");
    }
    return avgNumberOfRecord;
}

@Override
public String getMostPopularArtist() {
        String mostPopularArtist = null;
        String sql = "SELECT r.record_id, r.record_title, COUNT(*) AS popularity_count " +
                "FROM collection_record cr " +
                "JOIN records r ON cr.record_id = r.record_id " +
   "GROUP BY r.record_id, r.record_title " +
    "ORDER BY popularity_count DESC LIMIT 1;";
    SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
    try {
        if (result.next()) {
           mostPopularArtist = result.getString("record_artist");
        }
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (BadSqlGrammarException e) {
        throw new DaoException("Cannot get an Artist, bad sql grammar");
    }
    return mostPopularArtist;
}

@Override
public String getMostActiveUser() {
        String mostActiveUser = null;
        String sql = "SELECT ur.user_id, u.username, ur.record_count " +
                "FROM (SELECT user_id, COUNT(*) AS record_count FROM user_record " +
                "GROUP BY user_id ORDER BY record_count DESC " +
                "LIMIT 1) AS ur JOIN users AS u ON ur.user_id = u.user_id;";
    SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
    try {
        if (result.next()) {
            mostActiveUser = result.getString("username");
        }
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (BadSqlGrammarException e) {
        throw new DaoException("Cannot get an Artist, bad sql grammar");
    }
    return mostActiveUser;
}







    private AggregateDataDTO mapRowToAggregateData(SqlRowSet rowSet) {

        AggregateDataDTO aggregateDataDTO = new AggregateDataDTO();
        aggregateDataDTO.setUsername(rowSet.getString("username"));
      aggregateDataDTO.setCollectionId(rowSet.getInt("collection_id"));
      aggregateDataDTO.setPremium(rowSet.getBoolean("is_premium"));
      aggregateDataDTO.setRecordArtist(rowSet.getString("record_artist"));
      aggregateDataDTO.setRecordGenre(rowSet.getString("artist_genre"));
      aggregateDataDTO.setRecordTitle(rowSet.getString("record_title"));
      aggregateDataDTO.setRecordId(rowSet.getString("record_id"));
      aggregateDataDTO.setTagname(rowSet.getString("tag_name"));

        return aggregateDataDTO;
    }




    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setId(rowSet.getInt("collection_id"));
        collection.setUserId(rowSet.getInt("user_id"));
        collection.setUserName(userDao.getUserNameById(rowSet.getInt("user_id")));
        collection.setName(rowSet.getString("collection_name"));
        collection.setPublic(rowSet.getBoolean("is_public"));
        return collection;
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



