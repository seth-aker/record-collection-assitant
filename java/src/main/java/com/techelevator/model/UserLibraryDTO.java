package com.techelevator.model;

import java.util.List;

public class UserLibraryDTO {
    private List<RecordDTO> recordLibrary;
    private int userId;
    private List<Collection> userCollections;

    public List<RecordDTO> getRecordLibrary() {
        return recordLibrary;
    }

    public void setRecordLibrary(List<RecordDTO> recordLibrary) {
        this.recordLibrary = recordLibrary;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Collection> getUserCollections() {
        return userCollections;
    }

    public void setUserCollections(List<Collection> userCollections) {
        this.userCollections = userCollections;
    }
}
