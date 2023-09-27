package com.techelevator.model;

import java.util.List;

public class RecordDTO {

    private Record record;
    private List<Artist> artists;
    private List<String> genres;
    private String label;
    private Tracks tracks;
    private String imageUrl;

    public RecordDTO() {
    }

    public RecordDTO(Record record,
                     List<Artist> artists,
                     List<String> genres,
                     String label,
                     Tracks tracks)
    {
        this.record = record;
        this.artists = artists;
        this.genres = genres;
        this.label = label;
        this.tracks = tracks;

    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Artist> getArtist() {
        return artists;
    }

    public void setArtist(List<Artist> artists) {
        this.artists = artists;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenre(List<String> genres) {
        this.genres = genres;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
