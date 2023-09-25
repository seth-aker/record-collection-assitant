package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {

    List<Collection> getPublicCollections();

    List<Collection> getAllCollectionsByUserId(int id);

    Collection createCollection(Collection collection, int id);

    int deleteCollection(int id);
}
