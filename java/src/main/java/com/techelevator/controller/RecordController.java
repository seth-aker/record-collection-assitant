package com.techelevator.controller;


import com.techelevator.businessLogic.RecordLogic;
import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;
import com.techelevator.services.APIService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/records")
public class RecordController {

    private UserDao userDao;
    private RecordDao recordDao;
    private CollectionDao collectionDao;
    private APIService apiService;
    private RecordLogic recordLogic;

    public RecordController(RecordDao recordDao, UserDao userDao, CollectionDao collectionDao, APIService apiService){
        this.recordDao = recordDao;
        this.userDao = userDao;
        this.collectionDao = collectionDao;
        this.apiService = apiService;
        this.recordLogic = new RecordLogic(this.recordDao);
    }


    @GetMapping(path = "/{recordId}")
    public RecordDTO getRecordById(@Valid Principal principal, @PathVariable String recordId) {
        RecordDTO recordDTO = apiService.getRecordInformation(recordId);
        recordDTO.getRecord().setUserNote(recordDao.getRecordNote(recordId, principal));
        return recordDTO;

    }


    @GetMapping(path = "/search")
    public List<RecordDTO> getRecordSearchResults(@RequestParam(defaultValue = "") String q,
                                            @RequestParam(defaultValue = "") String type) {

        if(!q.equals("") && type.equals("album")) {
            return apiService.getAlbumSearch(q);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/records/{collectionId}")
    public void addRecordToCollection(@Valid Principal principal,
                                      @RequestBody RecordDTO recordDTO,
                                      @PathVariable int collectionId) {

        Record record = recordDTO.getRecord();
        int userId = userDao.findIdByUsername(principal.getName());
        if(!recordLogic.doesRecordExist(record)) {
            recordDao.createRecord(record);
        }
        if(!recordLogic.isRecordInUserLib(record, userId)){
            recordDao.addRecordToUserLib(record, userId);
        }
        collectionDao.addRecordToCollection(collectionId, record);
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
