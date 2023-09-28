package com.techelevator.services;

import com.techelevator.model.Artist;
import com.techelevator.model.RecordDTO;

import java.util.List;

public interface APIService {

    RecordDTO getRecordInformation(String recordId);

    List<RecordDTO> getAlbumSearch(String searchString);

    List<RecordDTO> getArtistSearch(String searchString);
}
