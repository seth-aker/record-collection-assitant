package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Genre;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcGenreDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcGenreDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Genre getGenreById(int id) {
        String sql = "SELECT genre_id, genre_name FROM genres WHERE genre_id = ?";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
            if (result.next()) {
                return mapRowToGenre(result);
            } else {
                return null;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }

    public int createGenre (Genre newGenre) {
        int id;
        String sql = "INSERT INTO genres (genre_name) VALUES (?) RETURNING genre_id;";

        try {
            id = jdbcTemplate.queryForObject(sql, Integer.class, newGenre.getName());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return id;
    }

    public boolean updateGenre (Genre genreToUpdate) {
        String sql = "UPDATE genres SET genre_name = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, genreToUpdate.getName());

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

    public int deleteGenreById(int id) {
        int numberOfRows;
        String artistGenreSql = "DELETE FROM artist_genre WHERE genre_id = ?;";
        String sql = "DELETE FROM genres WHERE genre_id = ?;";

        try {
            jdbcTemplate.update(artistGenreSql, id);
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

    public Genre mapRowToGenre(SqlRowSet rowSet) {
        Genre genre = new Genre();
        genre.setName(rowSet.getString("genre_name"));
        return genre;
    }

}
