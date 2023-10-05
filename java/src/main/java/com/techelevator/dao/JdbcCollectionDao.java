package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Record;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;

import com.techelevator.model.Collection;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao {

    private JdbcTemplate jdbcTemplate;

    private UserDao userDao;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public List<Collection> completeLibrary() {
        List<Collection> library = new ArrayList<>();
        String sql = "SELECT * FROM collections;";
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
        String sql = "SELECT collection_id, collection_name, user_id, is_public " +
                "FROM collections " +
                "WHERE is_public = true ";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                collections.add(mapRecordIdsToCollection(mapRowToCollection(results)));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }
    @Override
    public List<Collection> getPublicCollections(int numberOfCollections) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, user_id, is_public " +
                "FROM collections " +
                "WHERE is_public = true " +
                "LIMIT ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, numberOfCollections);
            while (results.next()) {
                collections.add(mapRecordIdsToCollection(mapRowToCollection(results)));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    @Override
    public List<Collection> getCollectionsByUserId(int id) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, user_id, is_public " +
                "FROM collections " +
                "WHERE user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                collections.add(mapRecordIdsToCollection(mapRowToCollection(results)));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    @Override
    public Collection getSingleCollectionByUserId(int userId, int collectionId) {
        Collection collection = null;
        String sql = "SELECT collection_id, collection_name, user_id, is_public " +
                "FROM collections " +
                "WHERE collection_id = ? AND user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId, userId);
            if (results.next()) {
                collection = mapRowToCollection(results);
            }
            return mapRecordIdsToCollection(collection);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e) {
            throw new DaoException("No collection found for collection id: "+collectionId, e);
        }
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
                collections.add(mapRecordIdsToCollection(mapRowToCollection(result)));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }



    @Override
    public Collection createCollection(Collection collection) {
        Collection createdCollection = null;
        String sql = "INSERT INTO collections (user_id, collection_name, is_public) " +
                     "VALUES (?, ?, ?) RETURNING collection_id;";
        try {
            int createdCollectionId = jdbcTemplate.queryForObject(sql, Integer.class, collection.getUserId(),
                    collection.getName(), collection.isPublic());
            createdCollection = getCollectionByCollectionId(createdCollectionId);
            return createdCollection;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (DataAccessException e) {
            throw new DaoException("Error while inserting a new collection", e);
        }
    }


    @Override
    public int deleteCollection(int id) {
        int numberOfRows = 0;
        String deleteCollectionRecordSql = "DELETE FROM collection_record WHERE collection_id = ?;";
        String deleteCollectionSql = "DELETE FROM collections WHERE collection_id = ?;";
        try {
            jdbcTemplate.update(deleteCollectionRecordSql, id);
            numberOfRows = jdbcTemplate.update(deleteCollectionSql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    @Override
    public boolean addRecordToCollection(int collectionId, Record record) {
        String sql = "INSERT INTO collection_record (collection_id, record_id) " +
                "VALUES (?, ?);";
        try {
            jdbcTemplate.update(sql, collectionId, record.getId());
            return true;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }
    @Override
    public Collection getCollectionByCollectionId(int id) {
        Collection collection = null;
        String sql = "SELECT collection_id, collection_name, user_id, is_public " +
                "FROM collections " +
                "WHERE collection_id= ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                collection = mapRowToCollection(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return mapRecordIdsToCollection(collection);
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

    private Collection mapRecordIdsToCollection(Collection collection) {
        String sql = "SELECT record_id " +
                "FROM collection_record " +
                "WHERE collection_id = ?";
        List<String> recordIds = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collection.getId());
            while (results.next()) {
                recordIds.add(results.getString("record_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e) {
            return collection;
        }
        collection.setRecordIds(recordIds);
        return collection;
    }
}
