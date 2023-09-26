package com.techelevator.model;

public class Record {

    private String id;
    private String title;
    private String userNote;

    public Record(){}

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

    public String getUserNote() {
        return userNote;
    }
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
