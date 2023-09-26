package com.techelevator.model;

public class Record {

    private int id;
    private String title;
    private String userNote;

    public Record(){}

    public Record(int id,String title, String note) {
        this.id = id;
        this.title = title;
        this.userNote = note;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
