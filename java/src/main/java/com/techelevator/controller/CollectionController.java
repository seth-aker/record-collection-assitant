package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
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
    public List<Collection> viewPublicCollections(){
            return this.collectionDao.getPublicCollections();
        }

    @RequestMapping(path = "/collections/user", method = RequestMethod.GET)
    public List<Collection> getUserCollections(Principal principal, @RequestParam(value= "name", required = false, defaultValue = "") String userName) {
        //checks if requester is user, if not shows only public collections of specified user
        if(userName.equals("") || userName.equals(principal.getName())) {
            return this.collectionDao.getCollectionsByUserId(userDao.findIdByUsername(principal.getName()));
        } else {
            return this.collectionDao.getUserPublicCollection(userDao.findIdByUsername(userName));
        }
    }

    @RequestMapping(path = "/user/collection/{id}", method = RequestMethod.GET)
    public Collection getCollection(@PathVariable int id, @Valid Principal principal) {
        return collectionDao.getCollectionByCollectionId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/user/collection/create", method = RequestMethod.POST)
    public Collection addCollection(@RequestBody Collection collection, @Valid Principal principal){
            collection.setUserId(userDao.findIdByUsername(principal.getName()));
            return this.collectionDao.createCollection(collection);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/user/collection/{id}")
    public void deleteCollection(@PathVariable int id, @Valid Principal principal) {
            collectionDao.deleteCollection(id);
    }
}