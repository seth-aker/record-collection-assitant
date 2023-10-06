package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CollectionController {


    private CollectionDao collectionDao;
    private UserDao userDao;
    private RecordDao recordDao;


    public CollectionController(CollectionDao collectionDao, UserDao userDao, RecordDao recordDao) {
        this.collectionDao = collectionDao;
        this.userDao = userDao;
        this.recordDao = recordDao;
    }

    @PreAuthorize("permitAll")
     @RequestMapping(path = "/collections/public", method = RequestMethod.GET)
    public List<Collection> viewPublicCollections() {
        return this.collectionDao.getPublicCollections();
    }

    @RequestMapping(path = "/collections/my-collections", method = RequestMethod.GET)
    public List<Collection> getUserCollections(Principal principal) {
        return this.collectionDao.getCollectionsByUserId(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/collections/{collectionId}", method = RequestMethod.GET)
    public Collection getCollection(@PathVariable int collectionId, @Valid Principal principal) {
        //record Ids are added to collection in the dao
        Collection collection = collectionDao.getCollectionByCollectionId(collectionId);
        if (collection.isPublic() || collection.getUserId() == userDao.findIdByUsername(principal.getName())) {
            return collection;
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/collections/create/{isPublic}", method = RequestMethod.POST)
    public Collection addCollection(@PathVariable boolean isPublic , @RequestBody Collection collection, @Valid Principal principal) {
        collection.setUserId(userDao.findIdByUsername(principal.getName()));
        collection.setPublic(isPublic);
        return this.collectionDao.createCollection(collection);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/collections/{collectionId}")
    public void addRecordToUserCollection(@RequestBody Record record, @PathVariable int collectionId) {
        collectionDao.addRecordToCollection(collectionId, record);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/collections/{collectionId}")
    public void deleteCollection(@PathVariable int collectionId, @Valid Principal principal) {
        collectionDao.deleteCollection(collectionId);
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/collections/public/{numberOfCollections}")
    public List<Collection> getTrendingCollections(@PathVariable int numberOfCollections) {
        return collectionDao.getPublicCollections(numberOfCollections);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/collections/{collectionId}/{recordId}")
    public Collection removeRecordFromCollection(@PathVariable int collectionId, @PathVariable String recordId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        Collection collection = collectionDao.getCollectionByCollectionId(collectionId);

        if(userId == collection.getUserId()) {
            recordDao.removeRecordFromCollection(collectionId, recordId);
            return collectionDao.getSingleCollectionByUserId(userId, collectionId);
        } else {
            throw new AccessDeniedException("403 returned");
        }
    }
}