package com.techelevator.dao;

import com.techelevator.model.AggregateDataDTO;
import com.techelevator.model.Record;


public interface AggregateDao {

    int getTotalNumberOfUsers();

    int getTotalNumberOfRecord();

    Record getMostPopularRecord();

    int getTotalNumberOfCollections();

    int getTotalPremiumUsers();

    int getAverageNumberOfRecordsInCollections();

    String getMostPopularArtist();

    String getMostActiveUser();
}
