package com.techelevator.model;

import java.util.List;

public class RecordDTO {

    private Record record;
    private List<Artist> artists;
    private List<Genre> genres;
    private Label label;
    private Collection collection;
    private List<Track> tracks;

    public RecordDTO() {
    }

    public RecordDTO(Record record, List<Artist> artists, List<Genre> genres, Label label, Collection collection, List<Track> tracks) {
        this.record = record;
        this.artists = artists;
        this.genres = genres;
        this.label = label;
        this.collection = collection;
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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTrack(List<Track> tracks) {
        this.tracks = tracks;
    }

}
