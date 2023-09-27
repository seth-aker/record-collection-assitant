package com.techelevator.services;

import com.techelevator.model.*;

import java.util.List;

public class RecordDTOBuilder {

    private SpotifyResponse spotifyResponse;

    public RecordDTO createRecordDTO(SpotifyResponse spotifyResponse) {
        this.spotifyResponse = spotifyResponse;
        RecordDTO recordDTO = new RecordDTO();
        recordDTO.setRecord(createRecord());
        recordDTO.setArtist(createArtists());
        recordDTO.setGenre(createGenres());
        recordDTO.setLabel(createLabel());
        recordDTO.setTracks(createTracks());
        recordDTO.setImageUrl(createImageUrl());
        return recordDTO;
    }

    private Record createRecord() {
        Record record = new Record();
        record.setId(this.spotifyResponse.getId());
        record.setTitle(this.spotifyResponse.getName());
        return record;
    }

    private List<Artist> createArtists() {
        List<Artist> artists = spotifyResponse.getArtists();
        return artists;
    }

    private List<String> createGenres() {
        List<String> genres = spotifyResponse.getGenres();
        return genres;
    }

    private String createLabel() {
        return spotifyResponse.getLabel();
    }

    private Tracks createTracks() {
        return spotifyResponse.getTracks();
    }

    private String createImageUrl() {
        return spotifyResponse.getImages().get(0).getUrl();
    }



}
