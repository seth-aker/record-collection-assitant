package com.techelevator.model;

import java.util.List;

public class RecordDTO {

    private Record record;
    private List<Artist> artists;
    private List<Genre> genres;
    private Label label;
    private List<Tracks> tracks;

    public RecordDTO() {
    }

    public RecordDTO(Record record,
                     List<Artist> artists,
                     List<Genre> genres,
                     Label label,
                     List<Tracks> tracks)
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenre(List<Genre> genres) {
        this.genres = genres;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<Tracks> getTracks() {
        return tracks;
    }

    public void setTrack(List<Tracks> tracks) {
        this.tracks = tracks;
    }

}
