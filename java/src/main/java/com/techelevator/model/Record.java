package com.techelevator.model;

public class Record {

    private int id;
    private String artist;
    private String title;
    private String note;
    private int year;

    public Record(int id, String artist, String title, String note, int year) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.note = note;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
