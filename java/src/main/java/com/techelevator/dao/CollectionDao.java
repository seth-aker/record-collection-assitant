package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {

    List<Collection> completeLibrary();

    List<Collection> getPublicCollections();

    List<Collection> getCollectionsByUserId(int id);

    List<Collection> getUserPublicCollection(int userId);

    Collection createCollection(Collection collection, int id);

    int deleteCollection(int id);
}
