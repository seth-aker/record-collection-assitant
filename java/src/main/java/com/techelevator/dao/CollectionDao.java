package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {

    List<Collection> completeLibrary();

    List<Collection> getPublicCollections();

    List<Collection> getCollectionsById(int id);

    Collection createCollection(Collection collection, int id);

    int deleteCollection(int id);
}
