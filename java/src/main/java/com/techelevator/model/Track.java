package com.techelevator.model;

public class Track {

    private String id;
    private String title;
    private String duration;
    private String number;


    public String getTrackId() {
        return id;
    }

    public void setTrackId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
