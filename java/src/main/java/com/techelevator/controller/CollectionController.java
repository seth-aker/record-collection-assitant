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

        @RequestMapping(path = "/getCollections/public", method = RequestMethod.GET)
        public List<Collection> viewPublicCollections(){
            return this.collectionDao.getPublicCollections();
        }

        @RequestMapping(path = "/user/collection", method = RequestMethod.GET)
    public List<Collection> showMyCollections(@Valid Principal principal) {
            int userId = userDao.findIdByUsername(principal.getName());
            return this.collectionDao.getCollectionsByUserId(userId);
        }

        @RequestMapping(path = "/user/collection/{id}", method = RequestMethod.GET)
            public Collection getCollection(@PathVariable int id) {
            return collectionDao.getCollectionByCollectionId(id);
        }

        @ResponseStatus(HttpStatus.CREATED)
        @RequestMapping(path = "/user/collection/create", method = RequestMethod.POST)
    public Collection addCollection(@RequestBody Collection collection, Principal principal){
            collection.setUserId(userDao.findIdByUsername(principal.getName()));
            return this.collectionDao.createCollection(collection);

    }
}