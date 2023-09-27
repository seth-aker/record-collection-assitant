package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {

    List<Collection> completeLibrary();

    List<Collection> getPublicCollections();

    List<Collection> getCollectionsByUserId(int id);


    List<Collection> getUserPublicCollection(int userId);

    Collection getCollectionByCollectionId(int id);


  Collection createCollection(Collection collection);


    int deleteCollection(int id);
}
