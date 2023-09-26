package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

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

        @RequestMapping(path = "/home", method = RequestMethod.GET)
        public List<Collection> viewPublicCollections(){
            return this.collectionDao.completeLibrary();
        }

        @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<Collection> showMyCollections(Principal principal) {
            return this.collectionDao.getCollectionsById(userDao.findIdByUsername(principal.getName()));
        }

        @RequestMapping(path = "/user/addCollection", method = RequestMethod.POST)
    public Collection addCollection(Principal principal, Collection collection){
            return this.collectionDao.createCollection(userDao.findIdByUsername(principal.getName()));

        }


    }
