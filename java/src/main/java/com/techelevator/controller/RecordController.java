package com.techelevator.controller;


import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.RecordDTO;
import com.techelevator.services.APIService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/records")
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
    public RecordDTO getRecordById(@PathVariable String recordId) {
       return apiService.getRecordInformation(recordId);
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
