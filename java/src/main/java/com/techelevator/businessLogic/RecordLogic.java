package com.techelevator.businessLogic;

import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;


import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RecordLogic {

    private int userId;
    private RecordDao recordDao;

    public RecordLogic(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public boolean doesRecordExist(String recordId) {
        try {
            //check to see if record exists in database.
            Record record = recordDao.getRecordById(recordId);
            if(record == null){
                return false;
            }
        } catch (DaoException e) {
            if (e.getMessage().equals("Record id does not exist")) {
                return false;
            }
        }
        return true;
    }

    public boolean isRecordInUserLib(String recordId, int userId) {
        List<Record> lib = recordDao.getUserLibrary(userId);

        //maps the library to a list of recordIds and then checks if that list already contains the record in question
        return lib.stream().map(Record::getId).collect(Collectors.toList()).contains(recordId);
    }







}
