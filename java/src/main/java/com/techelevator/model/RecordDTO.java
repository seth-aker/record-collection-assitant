package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.discogs.*;
import com.techelevator.model.discogs.Artist;
import org.springframework.boot.context.properties.bind.DefaultValue;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class RecordDTO {

    //Added from our database
    private List<String> tags;
    private String condition;
    private String userNotes = "";

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

    public RecordDTO() {
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
 this.tags = tags;



    }

    public String getCondition() {
        return condition;
    }


    public  void setCondition(String condition) {
        this.condition = condition;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<com.techelevator.model.discogs.Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<com.techelevator.model.discogs.Artist> artists) {
        this.artists = artists;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }

    public int getEstimatedWeight() {
        return estimatedWeight;
    }

    public void setEstimatedWeight(int estimatedWeight) {
        this.estimatedWeight = estimatedWeight;
    }

    public List<com.techelevator.model.discogs.Artist> getExtraArtists() {
        return extraArtists;
    }

    public void setExtraArtists(List<Artist> extraArtists) {
        this.extraArtists = extraArtists;
    }

    public int getFormatQuantity() {
        return formatQuantity;
    }

    public void setFormatQuantity(int formatQuantity) {
        this.formatQuantity = formatQuantity;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public float getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(float lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getReleasedFormatted() {
        return releasedFormatted;
    }

    public void setReleasedFormatted(String releasedFormatted) {
        this.releasedFormatted = releasedFormatted;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public List<Object> getSeries() {
        return series;
    }

    public void setSeries(List<Object> series) {
        this.series = series;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
