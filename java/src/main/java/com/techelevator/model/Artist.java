package com.techelevator.model;

import java.util.List;

public class Artist {

    private String id;
    private String name;
    private List<String> genres;

    public String getArtistId() {
        return id;
    }

    public void setArtistId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
