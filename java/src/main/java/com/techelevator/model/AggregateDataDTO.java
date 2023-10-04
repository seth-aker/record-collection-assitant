package com.techelevator.model;

public class AggregateDataDTO {



    // do we need these
    private int userId;

    private boolean isPremium;
    private int collectionId;

    // do a user of the day lol
    private String username;


    // for answers that are counts?
    private int numberReturned;
    private String recordId;
    private String recordArtist;
    private String recordGenre;
    private String recordTitle;
    private String tagname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumberReturned() {
        return numberReturned;
    }

    public void setNumberReturned(int numberReturned) {
        this.numberReturned = numberReturned;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordArtist() {
        return recordArtist;
    }

    public void setRecordArtist(String recordArtist) {
        this.recordArtist = recordArtist;
    }

    public String getRecordGenre() {
        return recordGenre;
    }

    public void setRecordGenre(String recordGenre) {
        this.recordGenre = recordGenre;
    }

    public String getRecordTitle() {
        return recordTitle;
    }

    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }


}
