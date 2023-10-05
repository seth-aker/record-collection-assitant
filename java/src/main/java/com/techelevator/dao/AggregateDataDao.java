package com.techelevator.dao;

import com.techelevator.model.Record;

import java.util.List;


public interface AggregateDataDao {

    int getTotalNumberOfUsers();

    List<Record> getTopTenRecords();

    Record getLeastPopularRecord();

    int getTotalNumberOfRecord();

    int numberOfTimesRecordAppears(String recordId);

    Record getMostPopularRecord();

    int getTotalNumberOfCollections();

    int getTotalPremiumUsers();

  double getAverageNumberOfRecordsInCollections();

    String getMostPopularArtist();

    String getLeastPopularArtist();

    List<String> topTenArtists();

    String getMostActiveUser();

    String getMostPopularGenre();

    String getLeastPopularGenre();

    List<Record> searchTagsPublic(String searchword);

    List<Record> searchTagsThroughPersonalCollection(String searchword, int userId);

    Record mostPopularRecordByArtist(String artistName);
}
