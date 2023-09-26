package com.techelevator.controller;

import com.techelevator.dao.RecordDao;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RecordController {

    private RecordDao recordDao;


    public RecordController(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @GetMapping(path = "/record/{id}")
    public Record getRecordById(@PathVariable String id) {
        Record returnRecord = new Record();
        returnRecord = recordDao.getRecordById(id);
        return returnRecord;
    }

    @PostMapping(path = "/record")
    public String createNewRecord(RecordDTO record) {
        String newId = "";
        Record newRecord = new Record();

        newRecord = record.getRecord();





        return newRecord.getId();
    }

}
