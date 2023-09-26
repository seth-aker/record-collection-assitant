package com.techelevator.dao;

import com.techelevator.model.Record;

import java.util.List;

public interface RecordDao {

    public Record getRecordById(int recordId);

    public List<Record> getUserLibrary(int userId);

    public void updateRecordNote(int id, String note);

}
