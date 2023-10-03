package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.Label;
import com.techelevator.model.User;
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


    @RequestMapping(path = "/collections/public", method = RequestMethod.GET)
    public List<Collection> viewPublicCollections() {
        return this.collectionDao.getPublicCollections();
    }

    @RequestMapping(path = "/collections/myCollections", method = RequestMethod.GET)
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
    @RequestMapping(path = "/collections/user/create", method = RequestMethod.POST)
    public Collection addCollection(@RequestBody Collection collection, @Valid Principal principal) {
        collection.setUserId(userDao.findIdByUsername(principal.getName()));
        return this.collectionDao.createCollection(collection);

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/collections/{collectionId}")
    public void deleteCollection(@PathVariable int collectionId, @Valid Principal principal) {
            collectionDao.deleteCollection(collectionId);
    }
}