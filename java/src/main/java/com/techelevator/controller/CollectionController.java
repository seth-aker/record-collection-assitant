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

        @RequestMapping(path = "/getCollections/public", method = RequestMethod.GET)
        public List<Collection> viewPublicCollections(){
            return this.collectionDao.getPublicCollections();
        }

        @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<Collection> showMyCollections(Principal principal) {
            return this.collectionDao.getCollectionsByUserId(userDao.findIdByUsername(principal.getName()));
        }

//        @RequestMapping(path = "/user/collections", method = RequestMethod.POST)
//    public Collection addCollection(@RequestBody Collection collection, Principal principal){
//            return this.collectionDao.createCollection(userDao.findIdByUsername(principal.getName()));
//
//        }


    }
