package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import com.techelevator.model.Collection;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao{

    private JdbcTemplate jdbcTemplate;

    private UserDao userDao;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Collection> completeLibrary(){
        List<Collection> library = new ArrayList<>();
       String sql = "SELECT collections.collection_id, collection_name FROM collections;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                library.add(mapRowToCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return library;
    }

    @Override
    public List<Collection> getPublicCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collections.collection_id, collection_name FROM collections " +
                "JOIN collection_user ON collections.collection_id = collection_user.collection_id " +
                "JOIN users ON users.user_id = collection_user.user_id WHERE is_public = true;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                collections.add(mapRowToCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    @Override
    public List<Collection> getCollectionsByUsername(String username) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collections.collection_id, collection_name FROM collections " +
                "JOIN collection_user ON collections.collection_id = collection_user.collection_id " +
                "JOIN users ON collection_user.user_id = users.user_id WHERE users.user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                collections.add(mapRowToCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    @Override
    public Collection createCollection(Collection collection, int id) {
        Collection newCollection = new Collection();
        String sql = "INSERT INTO collections (collection_name) " +
                "VALUES (?) RETURNING collection_id;";
        Integer collectionId;
        try {
            collectionId = jdbcTemplate.queryForObject(sql,Integer.class,
                    collection.getName());
            collection.setId(collectionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return collection;
    }

    @Override
    public int deleteCollection(int id) {
        int numberOfRows = 0;
        String sql = "DELETE FROM collection WHERE collection_id = ?;";
        try {
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



    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setId(rowSet.getInt("collection_id"));
        collection.setName(rowSet.getString("collection_name"));
        collection.setPublic(rowSet.getBoolean("is_public"));
        return collection;
    }
}
