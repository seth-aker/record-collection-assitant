package com.techelevator.model;

import java.util.List;

public class DataStatsDTO {


    private int recordCount;
    private int memberCount;
    private int collectionCount;
    private int premiumUserCount;
    private double avgRecordsInCollection;
    private String mostActiveUser;


    private List <Record> artistsBestRecord;
    private int downloadNumber;



    private List<Record> topTenRecords;
    private Record topRecord;
    private List<String> topTenArtists;
    private String topArtist;
    private String topGenre;



    private List<Record> publicSearchTags;
    private   List<Record> privateSearchTags;




    public int getDownloadNumber() {
        return downloadNumber;
    }

    public void setDownloadNumber(int downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    public List<Record> getPublicSearchTags() {
        return publicSearchTags;
    }

    public void setPublicSearchTags(List<Record> publicSearchTags) {
        this.publicSearchTags = publicSearchTags;
    }

    public List<Record> getPrivateSearchTags() {
        return privateSearchTags;
    }

    public void setPrivateSearchTags(List<Record> privateSearchTags) {
        this.privateSearchTags = privateSearchTags;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }

    public int getPremiumUserCount() {
        return premiumUserCount;
    }

    public void setPremiumUserCount(int premiumUserCount) {
        this.premiumUserCount = premiumUserCount;
    }

    public double getAvgRecordsInCollection() {
        return avgRecordsInCollection;
    }

    public void setAvgRecordsInCollection(double avgRecordsInCollection) {
        this.avgRecordsInCollection = avgRecordsInCollection;
    }

    public List<Record> getTopTenRecords() {
        return topTenRecords;
    }

    public void setTopTenRecords(List <Record> topTenRecords) {
        this.topTenRecords = topTenRecords;
    }

    public Record getTopRecord() {
        return topRecord;
    }

    public void setTopRecord(Record topRecord) {
        this.topRecord = topRecord;
    }

    public List<String> getTopTenArtists() {
        return topTenArtists;
    }

    public void setTopTenArtists(List<String> topTenArtists) {
        this.topTenArtists = topTenArtists;
    }

    public String getTopArtist() {
        return topArtist;
    }

    public void setTopArtist(String topArtist) {
        this.topArtist = topArtist;
    }

    public String getTopGenre() {
        return topGenre;
    }

    public void setTopGenre(String topGenre) {
        this.topGenre = topGenre;
    }

    public String getMostActiveUser() {
        return mostActiveUser;
    }

    public void setMostActiveUser(String mostActiveUser) {
        this.mostActiveUser = mostActiveUser;
    }

    @Override
    public String toString() {
        return "AggregatedDataDTO{" +
                "artistsBestRecord=" + artistsBestRecord +
                ", downloadNumber=" + downloadNumber +
                ", publicSearchTags=" + publicSearchTags +
                ", privateSearchTags=" + privateSearchTags +
                ", recordCount=" + recordCount +
                ", memberCount=" + memberCount +
                ", collectionCount=" + collectionCount +
                ", premiumUserCount=" + premiumUserCount +
                ", avgRecordsInCollection=" + avgRecordsInCollection +
                ", topTenRecords=" + topTenRecords +
                ", topRecord=" + topRecord +
                ", topTenArtists=" + topTenArtists +
                ", topArtist='" + topArtist + '\'' +
                ", topGenre='" + topGenre + '\'' +
                ", mostActiveUser='" + mostActiveUser + '\'' +
                '}';
    }
}
