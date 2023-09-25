package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import com.techelevator.model.Collection;
import java.util.List;

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

    public Collection createCollection(Collection collection, int id) {
        Collection newCollection = new Collection();
        String sql = "INSERT INTO collection (collection_name) " +
                "VALUES (?) RETURNING collection_id";
        try {
            Integer newCollectionId = jdbcTemplate.queryForObject(sql,Integer.class,
                    collection.g);

            collection.setId(newCollectionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return collection;

    }






    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setId(rowSet.getInt("collection_id"));
        collection.setName(rowSet.getString("collection_name"))
        collection.isPublic(rowSet.getBoolean("is_public"));
        return  collection;
    }


}
