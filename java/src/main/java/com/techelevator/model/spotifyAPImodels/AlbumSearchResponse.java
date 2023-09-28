package com.techelevator.model.spotifyAPImodels;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class AlbumSearchResponse {
    private String href;

    @JsonAlias(value = "items")
    private List<SpotifyResponse> spotifyResponses;
    private int limit;
    private String next;
    private int offset;
    private Object previous;
    private int total;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<SpotifyResponse> getSpotifyResponses() {
        return spotifyResponses;
    }

    public void setSpotifyResponses(List<SpotifyResponse> spotifyResponses) {
        this.spotifyResponses = spotifyResponses;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
