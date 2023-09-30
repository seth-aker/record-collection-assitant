package com.techelevator.model.discogs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.techelevator.model.Label;
import com.techelevator.model.Image;

import java.util.List;

public class ReleaseDTO extends Release{

    // Added from our database
    private List<String> tags;
    private String condition;
    private String userNotes;

    // From discogs
    private String title;
    private int id;
    private List<Artist> artists;
    private String thumb;
    private List<Company> companies;
    private String country;
    private String dateAdded;
    private String dateChanged;
    private int estimatedWeight;
    @JsonAlias(value = "extraartists")
    private List<Artist> extraArtists;
    private int formatQuantity;
    private List<Format> formats;
    private List<String> genres;
    private List<Identifier> identifiers;
    private List<Image> images;
    private List<Label> labels;
    private float lowestPrice;
    private int masterId;
    private String masterUrl;
    private String notes;
    private String released;
    private String releasedFormatted;
    private String resourceUrl;
    private List<Object> series;
    private String status;
    private List<String> styles;
    @JsonAlias(value = "tracklist")
    private List<Track> trackList;
    private String uri;
    private List<Video> videos;
    private int year;


    public List<String> getTags() {
        return tags;
    }

    public void setTags(String tag) {
        this.tags = tags;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }


}
