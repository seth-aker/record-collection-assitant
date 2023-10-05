package com.techelevator.controller;


import com.techelevator.businessLogic.RecordLogic;
import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;

import com.techelevator.services.APIService;


import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


    @PreAuthorize("permitAll")
    @GetMapping(path = "/{recordId}")
    public RecordDTO getRecordById(@Valid Principal principal, @PathVariable String recordId) {
        RecordDTO recordDTO = apiService.getRecordInformation(recordId);
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            String[] recordNotesAndCondition = (recordDao.getRecordNoteAndCondition(recordId, userId));
            List<String> tags = new ArrayList<>();
            if(recordLogic.isRecordInUserLib(recordId, userId)) {
               tags.addAll(recordDao.getRecordTags(recordId, userId));
            }
            recordDTO.setUserNotes(recordNotesAndCondition[0]);
            recordDTO.setCondition(recordNotesAndCondition[1]);
            recordDTO.setTags(tags);
        } catch (DaoException | NullPointerException e) {
            return recordDTO;
        }

        return recordDTO;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{recordId}", method = RequestMethod.PUT)
    public RecordDTO updateRecord(@RequestBody RecordDTO recordDTO, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());

        try {
            Record recordToUpdate = recordDao.getRecordById(String.valueOf(recordDTO.getId()));
            if (recordLogic.isRecordInUserLib(recordToUpdate.getId(), userId)) {
                recordDao.updateTags(recordDTO.getTags(), String.valueOf(recordDTO.getId()), userId);
                recordDao.updateRecordNote(String.valueOf(recordDTO.getId()), userId, recordDTO.getUserNotes());
                recordDao.updateCondition(String.valueOf(recordDTO.getId()), recordDTO.getCondition(), userId);
            }
            return recordDTO;
        } catch (DaoException e) {
            throw new DaoException("Record not in library.", e);
        }
    }

    @GetMapping(path = "")
    public List<Record> getUserLibrary(@Valid Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        List<Record> userLib = new ArrayList<>();

        try {
            userLib = recordDao.getUserLibrary(userId);
        } catch (DaoException e) {
            throw new DaoException("User library not found.", e);
        }
        return userLib;

    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public void addRecordToUserLib(@RequestBody RecordDTO recordDTO, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        String recordId = String.valueOf(recordDTO.getId());
        if (!recordLogic.doesRecordExist(recordId)) {
            recordDao.createRecord(new Record(recordId, recordDTO.getTitle(), recordDTO.getImages().get(0).getUri(), recordDTO.getArtists().get(0).getName(),"", ""));
        }
        if (!recordLogic.isRecordInUserLib(recordId, userId)) {
            recordDao.addRecordToUserLib(recordId, userId);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{recordId}")
    public void deleteRecordFromUserLib(@PathVariable String recordId, Principal principal ) {
        int userId = userDao.findIdByUsername(principal.getName());

        if(recordLogic.doesRecordExist(recordId)) {
            List<Collection> collections = collectionDao.getCollectionsByUserId(userId);
            for(Collection collection : collections) {
                recordDao.removeRecordFromCollection(collection.getId(), recordId);
            }
            recordDao.removeRecordFromUserLib(recordId, userId);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{recordId}/{tagName}")
        public void removeTagFromRecord(@PathVariable String recordId, @PathVariable String tagName,  Principal principal ) {
        int userId = userDao.findIdByUsername(principal.getName());

        recordDao.removeTag(tagName, userId, recordId);

    }

}

