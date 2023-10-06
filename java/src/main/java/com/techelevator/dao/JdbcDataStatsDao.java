package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Record;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDataStatsDao implements DataStatsDao {

    private final JdbcTemplate jdbcTemplate;

    private UserDao userDao;

    public JdbcDataStatsDao(JdbcTemplate jdbcTemplate) {
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
    public int numberOfTimesRecordAppears(String recordId) {
        int number = 0;
        String sql = "SELECT COUNT(*) AS times_added " +
                "FROM collection_record " +
                "WHERE record_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if (results.next()) {
                number = results.getInt("times_added");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Bad sql grammar dude");
        }
        return number;
    }

    @Override
    public Record getMostPopularRecord() {
        Record record = null;
        String sql = "SELECT record_id, record_image, record_artist, record_title, COUNT(*) AS popularity_count " +
                "FROM records " +
                "GROUP BY record_id " +
                "ORDER BY popularity_count DESC " +
                "LIMIT 1;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
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
    public List<Record> getTopTenRecords() {
        List<Record> topTen = new ArrayList<>();
        String sql = "SELECT record_id, record_image, record_artist, " +
                "record_title, COUNT(*) AS popularity_count " +
                "FROM records " +
                "GROUP BY record_id " +
                "ORDER BY popularity_count DESC " +
                "LIMIT 25;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
            while (result.next()) {
                topTen.add(mapRowToRecord(result));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("There is no most popular record");
        }
        return topTen;

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
    public int getTotalNumberOfCollections() {
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
    public int getTotalPremiumUsers() {
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
    public double getAverageNumberOfRecordsInCollections() {
        double avgNumberOfRecord = 0;
        String sql = "SELECT AVG(record_count) AS avg_records_per_collection FROM " +
                "(SELECT collection_id, COUNT(*) AS record_count " +
                "FROM collection_record GROUP BY collection_id) AS subquery;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        try {
            if (result.next()) {
                avgNumberOfRecord = result.getDouble("avg_records_per_collection");
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
        String sql = "SELECT r.record_id, r.record_artist, COUNT(*) AS popularity_count " +
                "FROM collection_record cr " +
                "JOIN records r ON cr.record_id = r.record_id " +
                "GROUP BY r.record_id, r.record_artist " +
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
    public List<String> topTenArtists() {
        List<String> mostPopularArtist = new ArrayList<>();
        String sql = "SELECT record_artist, COUNT(*) AS record_count FROM records " +
                "GROUP BY record_artist ORDER BY record_count DESC LIMIT 10;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        try {
            while (result.next()) {
                mostPopularArtist.add(result.getString("record_artist"));
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
            throw new DaoException("Cannot get an User, bad sql grammar");
        }
        return mostActiveUser;
    }

    @Override
    public String getMostPopularGenre() {
        String mostPopularGenre = null;
        String sql = "SELECT r.artist_genre AS most_popular_genre, COUNT(*) AS genre_count " +
                "FROM records r GROUP BY r.artist_genre ORDER BY genre_count DESC LIMIT 1;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        try {
            if (result.next()) {
                mostPopularGenre = result.getString("artist_genre");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Cannot get an genre, bad sql grammar");
        }
        return mostPopularGenre;
    }


    @Override
    public List<Record> searchTagsPublic(String searchword) {
        List<Record> recordsWithTag = new ArrayList<>();
        String sql = "SELECT r.*\n" +
                "FROM records r\n" +
                "JOIN user_record_tag urt ON r.record_id = urt.record_id\n" +
                "WHERE urt.tag_name = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, searchword);
        try {
            while (result.next()) {
                recordsWithTag.add(mapRowToRecord(result));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("No tags for you, bad sql grammar");
        }
        return recordsWithTag;
    }

    @Override
    public List<Record> searchTagsThroughPersonalCollection(String searchword, int userId) {
        List<Record> recordsWithTag = new ArrayList<>();
        String sql = "SELECT r.* FROM records r " +
                "JOIN collection_record cr ON r.record_id = cr.record_id " +
                "JOIN collections c ON cr.collection_id = c.collection_id " +
                "JOIN user_record_tag urt ON r.record_id = urt.record_id " +
                "JOIN tags t ON urt.tag_name = t.tag_name WHERE t.tag_name = ? " +
                "AND c.user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, searchword, userId);
        try {
            while (result.next()) {
                recordsWithTag.add(mapRowToRecord(result));
            }
        } catch (EmptyResultDataAccessException e) {
            throw new DaoException("No records found for the given tag: " + searchword);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("No tags for you, bad sql grammar");
        }
        return recordsWithTag;
    }


    @Override
    public Record mostPopularRecordByArtist(String artistName) {
        Record mostPopularRecord = null;
        String sql = "SELECT r.record_artist, r.record_id AS most_popular_album " +
                "FROM records r " +
                "WHERE r.record_artist = ? " +
                "ORDER BY (SELECT COUNT(*) FROM collection_record cr WHERE cr.record_id = r.record_id) DESC " +
                "LIMIT 1;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, artistName);
        try {
            if (result.next()) {
                mostPopularRecord = mapRowToRecord(result);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Unable to retrieve the most popular record by artist");
        }
        return mostPopularRecord;
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



