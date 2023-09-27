package com.techelevator.controller;


import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import com.techelevator.services.RecordDTOBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.Objects;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class RecordController {

    private RecordDTOBuilder recordDTOBuilder;
    private UserDao userDao;

}



//    public RecordController(RecordDTOBuilder recordDTOBuilder, UserDao userDao){
//        this.recordDTOBuilder = recordDTOBuilder;
//        this.userDao = userDao;
//    }
//
//
//    @GetMapping(path = "/record/{id}")
//    public RecordDTO getRecordById(@PathVariable String recordId) {
//       return recordDTOBuilder.getRecordById(recordId);
//    }
//
//    @PostMapping(path = "/record")
//    public String createNewRecord(Principal principal, RecordDTO recordDTO) {
//        int userId = userDao.findIdByUsername(principal.getName());
//        if(recordDTO.getRecord().getId() == null || recordDTO.getRecord().getId().equals("")) {
//            recordDTOBuilder.addRecordToDb(recordDTO, String.valueOf(Objects.hash(recordDTO.getRecord(), recordDTO.getArtist())), userId );
//        } else {
//            recordDTOBuilder.addRecordToDb(recordDTO, userId);
//        }
//        Record newRecord = recordDTO.getRecord();
//
//        return newRecord.getId();
//    }
//
//}
