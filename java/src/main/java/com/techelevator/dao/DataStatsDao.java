package com.techelevator.dao;

import com.techelevator.model.Record;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DataStatsDao {

    int getTotalNumberOfUsers();

    List<Record> getTopTenRecords();

    int getTotalNumberOfRecord();

    Record getMostPopularRecord();

    int getTotalNumberOfCollections();

    int getTotalPremiumUsers();

  double getAverageNumberOfRecordsInCollections();

    String getMostPopularArtist();

    List<String> topTenArtists();

    String getMostActiveUser();

    List<Record> searchTagsPublic(String searchword);

    List<Record> searchTagsThroughPersonalCollection(String searchword, int userId);

    Record mostPopularRecordByArtist(String artistName);

    int numberOfTimesRecordAppears(String recordId);

    String getMostPopularGenre();
}
