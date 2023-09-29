package com.techelevator.services;

import com.techelevator.model.*;
import com.techelevator.model.spotifyAPImodels.Artist;
import com.techelevator.model.spotifyAPImodels.SpotifyResponse;
import com.techelevator.model.spotifyAPImodels.Tracks;

import java.util.List;

public class RecordDTOBuilder {

    private SpotifyResponse spotifyResponse;

    public RecordDTO createRecordDTO(SpotifyResponse spotifyResponse) {
        this.spotifyResponse = spotifyResponse;
        RecordDTO recordDTO = new RecordDTO();
        return recordDTO;
    }

    private Record createRecord() {
        Record record = new Record();
        record.setId(this.spotifyResponse.getId());
        record.setTitle(this.spotifyResponse.getName());
        return record;
    }

    private List<Artist> createArtists() {
        return spotifyResponse.getArtists();
    }

    private List<String> createGenres() {
        return spotifyResponse.getGenres();
    }

    private String createLabel() {
        return spotifyResponse.getLabel();
    }

    private Tracks createTracks() {
        return spotifyResponse.getTracks();
    }

    private String createImageUrl() {
        return spotifyResponse.getImages().get(0).getUri();
    }

    private int createPopularity() {
        return spotifyResponse.getPopularity();
    }

}
