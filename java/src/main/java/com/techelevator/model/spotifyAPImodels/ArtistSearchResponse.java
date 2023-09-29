package com.techelevator.model.spotifyAPImodels;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class ArtistSearchResponse {

    private String href;
    private int limit;
    private int total;
    @JsonAlias(value = "items")
    private List<Artist> artists;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

}

