package com.techelevator.dao;

import com.techelevator.model.Record;

import java.security.Principal;
import java.util.List;

public interface RecordDao {

    public Record getRecordById(String recordId);

    public List<Record> getUserLibrary(int userId);

    boolean createTags(Record record, String tagName);


    boolean updateTags(String tagName, String recordId, int userId);

    boolean deleteTags(int userId, int recordId);

    boolean updateCondition(String recordId, String condition, int userId);

    public boolean updateRecordNote(String recordId, int userId, String note);

    public boolean createRecord(Record record);

    public boolean addRecordToUserLib(Record record, int userId);

    public boolean removeRecordFromUserLib(Record record, int userId);


    public String getRecordNote(String recordId, Principal principal);


    public String[] getRecordNoteAndCondition(String recordId, Principal principal);

    public List<String> getRecordTags(String recordId, Principal principal);

}
