package com.techelevator.dao;

import com.techelevator.model.Artist;

import java.util.List;

public interface ArtistDao {
     Artist getArtistById (String id);
     List<Artist> getRecordArtists(String recordId);
     boolean updateArtist(Artist artist);
     void addArtist(Artist artist);
     int deleteArtistById(int id);
}
