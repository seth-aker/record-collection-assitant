package com.techelevator.model;

import java.util.List;

public class Record {

    private String id;
    private String title;
    private String thumb;
    private String artist;
    private String userNote;
    private String condition;


    public Record(){}

    public Record(String id, String title, String image, String artist, String userNote, String condition) {
        this.id = id;
        this.title = title;
        this.thumb = image;
        this.artist = artist;
        this.userNote = userNote;
        this.condition = condition;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
