package com.techelevator.model;

public class Track {

    private int id;
    private String title;
    private String duration;
    private String position;


    public Track (String duration, String position, String title) {
        this.duration = duration;
        this.position = position;
        this.title = title;
    }

    public int getTrackId() {
        return id;
    }

    public void setTrackId(int id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
