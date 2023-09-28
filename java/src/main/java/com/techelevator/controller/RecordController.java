package com.techelevator.controller;


import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;
import com.techelevator.services.APIService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/records")
public class RecordController {

    private UserDao userDao;
    private RecordDao recordDao;
    private APIService apiService;

    public RecordController(RecordDao recordDao, UserDao userDao, APIService apiService){
        this.recordDao = recordDao;
        this.userDao = userDao;
        this.apiService = apiService;
    }


    @GetMapping(path = "/{recordId}")
    public RecordDTO getRecordById(Principal principal, @PathVariable String recordId) {
        RecordDTO recordDTO = apiService.getRecordInformation(recordId);
        recordDTO.getRecord().setUserNote(recordDao.getRecordNote(recordId, principal));
        return recordDTO;

    }


    @GetMapping(path = "/search")
    public List<RecordDTO> getRecordSearchResults(@RequestParam(defaultValue = "") String q) {

        if(!q.equals("")) {
            return apiService.getAlbumSearch(q);
        }
        return null;
    }
}


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
