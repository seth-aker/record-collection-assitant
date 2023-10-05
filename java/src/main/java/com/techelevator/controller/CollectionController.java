package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
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


        public CollectionController(CollectionDao collectionDao, UserDao userDao) {
            this.collectionDao = collectionDao;
            this.userDao = userDao;
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
            if (collection.isPublic() || collection.getUserId() == userDao.findIdByUsername(principal.getName())){
                return collection;
            } else {
                return null;
            }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/collections/create", method = RequestMethod.POST)
    public Collection addCollection(@RequestBody Collection collection, @Valid Principal principal) {
            Collection newCollection = new Collection();
            newCollection.setUserId(userDao.findIdByUsername(principal.getName()));
            newCollection.setPublic(collection.isPublic());
            newCollection.setName(collection.getName());
        collection.setUserId(userDao.findIdByUsername(principal.getName()));
        return this.collectionDao.createCollection(newCollection);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/collections/{collectionId}")
    public void addRecordToUserCollection(@RequestBody Record record, @PathVariable int collectionId) {
            collectionDao.addRecordToCollection(collectionId,record);
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
}