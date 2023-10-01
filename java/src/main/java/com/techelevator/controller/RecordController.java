package com.techelevator.controller;


import com.techelevator.businessLogic.RecordLogic;
import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;
import com.techelevator.model.discogs.SearchResponse;
import com.techelevator.services.APIService;


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


    public RecordController(RecordDao recordDao, UserDao userDao, CollectionDao collectionDao, APIService apiService) {
        this.recordDao = recordDao;
        this.userDao = userDao;
        this.collectionDao = collectionDao;
        this.apiService = apiService;
        this.recordLogic = new RecordLogic(this.recordDao);
    }


    @GetMapping(path = "/{recordId}")
    public RecordDTO getRecordById(@Valid Principal principal, @PathVariable String recordId) {
        RecordDTO recordDTO = apiService.getRecordInformation(recordId);
        String[] recordNotesAndCondition = (recordDao.getRecordNoteAndCondition(recordId, principal));
        List<String> tags = recordDao.getRecordTags(recordId, principal);

        recordDTO.setUserNotes(recordNotesAndCondition[0]);
        recordDTO.setCondition(recordNotesAndCondition[1]);
        recordDTO.setTags(tags);
        return recordDTO;
    }

    @RequestMapping(path = "/records/{recordId}", method = RequestMethod.PUT)
    public RecordDTO updateRecord(@RequestBody RecordDTO recordDTO, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());

        try {
            Record recordToUpdate = recordDao.getRecordById(String.valueOf(recordDTO.getId()));
            if (recordLogic.isRecordInUserLib(recordToUpdate, userDao.findIdByUsername(principal.getName()))) {
                recordDao.updateTags(recordDTO.getTags(), String.valueOf(recordDTO.getId()), userId);
                recordDao.updateRecordNote(String.valueOf(recordDTO.getId()), userId, recordDTO.getUserNotes());
                recordDao.updateCondition(String.valueOf(recordDTO.getId()), recordDTO.getCondition(), userId);
            }
        } catch (DaoException e) {
            throw new DaoException("Record not in library.", e);
        }
        return recordDTO;

    }


    // This will add a single tag into the tags array vs the whole array @once
    //    (We can fill it with tags but should we do it one at a time or all at once?

//    public void setTags(String tag) {
//        if(tags != null && !tags.isEmpty()) {
//            tags.add(tag);
//
//
//        }
//    }


    public RecordDTO mapNoteTagCondition(Record record, Principal principal) {
        RecordDTO recordDTO = new RecordDTO();
        try {
            Object[] noteAndCondition = recordDao.getRecordNoteAndCondition(record.getId(), principal);
            String note = (noteAndCondition != null && noteAndCondition.length > 0) ? noteAndCondition[0].toString() : null;
            String condition = (noteAndCondition != null && noteAndCondition.length > 1) ? noteAndCondition[1].toString() : null;
            List<String> tags = recordDao.getRecordTags(record.getId(), principal);
            recordDTO.setUserNotes(note);
            recordDTO.setTags(tags);
            recordDTO.setCondition(condition);
        } catch (DaoException e) {
            throw new DaoException("Needs some better handling error here", e);
        }
        return recordDTO;
    }


//    @RequestMapping(path = "/set-tags", method = RequestMethod.PUT)
//    public ResponseEntity addRecordTag(@RequestParam String tag, Principal principal, @RequestParam int recordId) {
//
//
//    }

}


//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(path = "/{collectionId}")
//    public void addRecordToCollection(@Valid Principal principal,
//                                      @RequestBody RecordDTO recordDTO,
//                                      @PathVariable int collectionId) {
//
//        Record record = recordDTO.getRecord();
//        int userId = userDao.findIdByUsername(principal.getName());
//        if(!recordLogic.doesRecordExist(record)) {
//            recordDao.createRecord(record);
//        }
//        if(!recordLogic.isRecordInUserLib(record, userId)){
//            recordDao.addRecordToUserLib(record, userId);
//        }
//        collectionDao.addRecordToCollection(collectionId, record);
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
