package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Record;

import java.util.List;

public interface CollectionDao {

    List<Collection> completeLibrary();

    List<Collection> getPublicCollections();

    List<Collection> getPublicCollections(int numberOfCollections);

    List<Collection> getCollectionsByUserId(int id);


    Collection getSingleCollectionByUserId(int UserId, int collectionId);

    List<Collection> getUserPublicCollection(int userId);

    Collection getCollectionByCollectionId(int id);


    Collection createCollection(Collection collection);


    int deleteCollection(int id);

    boolean addRecordToCollection(int collectionId, Record record);

}
