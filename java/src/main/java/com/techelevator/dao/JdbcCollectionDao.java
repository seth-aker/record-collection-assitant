package com.techelevator.dao;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;

public class JdbcCollectionDao implements CollectionDao{

    private JdbcTemplate jdbcTemplate;

    private UserDao userDao;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Collection> getAllCollections(int id) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, is_public FROM collection " +
                "JOIN collection_user ON collection.collection_id = collection.collection_id " +
                "JOIN users ON users.user_id = collection_users.user_id WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                collections.add(mapRowToCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;

    }




    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setId(rowSet.getInt("collection_id"));
        collection.setName(rowSet.getString("collection_name"))
        collection.setIsPublic(rowSet.getBoolean("is_public"));
        collection.setRecordId(rowSet.getInt("record_id"));
        return  collection;
    }


}
