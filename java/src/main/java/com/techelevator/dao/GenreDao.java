package com.techelevator.dao;

import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getArtistGenres(String artistId);
    Genre getGenreById(int id);
    int createGenre (Genre newGenre);
    boolean updateGenre (Genre genreToUpdate);
    int deleteGenreById(int id);

}
