package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.dao.DataAccessException;
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


    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Collection> completeLibrary(){
        List<Collection> library = new ArrayList<>();
       String sql = "SELECT FROM collections;";
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
        String sql = "SELECT collection_id, collection_name FROM collections " +
                "WHERE is_public = true";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                collections.add(mapRowToCollection(results, true));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    @Override
    public List<Collection> getCollectionsByUserId(int id) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name FROM collections " +
                "WHERE user_id = ?;";
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

    @Override
    public List<Collection> getUserPublicCollection(int userId) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, user_id, is_public " +
                "FROM collections " +
                "WHERE user_id = ? AND is_public = true";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
            while (result.next()) {
                collections.add(mapRowToCollection(result));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    @Override
    public Collection getCollectionByCollectionId(int id) {
        Collection collection = null;
        String sql = "SELECT collection_id, collection_name FROM collections WHERE collection_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if(results.next()) {
                collection = mapRowToCollection(results, true);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collection;
    }

    @Override
    public Collection createCollection(Collection collection) {
        Collection createdCollection = null;
        String sql = "INSERT INTO collections (user_id, collection_name, is_public) " +
                "VALUES (?, ?, ?);";
        try {
            int createdCollectionId = jdbcTemplate.update(sql, collection.getUserId(),
                    collection.getName(), collection.isPublic());
            createdCollection = getCollectionByCollectionId(createdCollectionId);
            return createdCollection;
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }catch (DataAccessException e) {
            throw new DaoException("Error while inserting a new collection", e);
        }
    }


    @Override
    public int deleteCollection(int id) {
        int numberOfRows = 0;
        String collectionRecordSql = "DELETE FROM collection_record WHERE collection_id= ?;";
        String sql = "DELETE FROM collections WHERE collection_id = ?;";
        try {
            jdbcTemplate.update(collectionRecordSql, id);
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
        collection.setUserId(rowSet.getInt("user_id"));
        collection.setName(rowSet.getString("collection_name"));
        collection.setPublic(rowSet.getBoolean("is_public"));
        return collection;
    }

    private Collection mapRowToCollection(SqlRowSet rowSet,boolean notAllColumns) {
        Collection collection = new Collection();
        if (notAllColumns == true) {
            collection.setId(rowSet.getInt("collection_id"));
            collection.setName(rowSet.getString("collection_name"));
            }
        return collection;
    }
}
