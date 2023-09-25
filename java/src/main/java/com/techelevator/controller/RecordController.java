package com.techelevator.controller;

import com.techelevator.dao.RecordDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RecordController {

    private RecordDao recordDao;


    public RecordController(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

}
