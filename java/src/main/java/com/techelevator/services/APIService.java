package com.techelevator.services;

import com.techelevator.model.RecordDTO;
import com.techelevator.model.discogs.SearchResponse;

import java.util.List;

public interface APIService {

    RecordDTO getRecordInformation(String recordId);

    SearchResponse getAlbumSearch(String query, int perPage, String type, int page, String genre);

    SearchResponse getArtistSearch(String searchString);
}
