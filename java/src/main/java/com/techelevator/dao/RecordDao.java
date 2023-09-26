package com.techelevator.dao;

import com.techelevator.model.Record;

import java.util.List;

public interface RecordDao {

    public Record getRecordById(String recordId);

    public List<Record> getUserLibrary(int userId);

    public void updateRecordNote(String recordId, int userId, String note);

    public boolean createRecord(String recordId, String recordTitle);

    public boolean addRecordToUserLib(Record record, int userId);

    public boolean removeRecordFromUserLib(Record record, int userId);
}
