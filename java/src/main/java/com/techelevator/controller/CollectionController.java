package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class CollectionController {

    private CollectionDao collectionDao;
    private UserDao userDao;

    public CollectionController(CollectionDao collectionDao) {
            this.collectionDao = collectionDao;
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

    @RequestMapping(path = "/collections/user", method = RequestMethod.POST)
    public Collection addCollection(Principal principal, Collection collection){
        return this.collectionDao.createCollection(collection, userDao.findIdByUsername(principal.getName()));
    }


    }
