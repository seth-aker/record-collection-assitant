package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class CollectionController {
        private CollectionDao collectionDao;

        public CollectionController(CollectionDao collectionDao) {
            this.collectionDao = collectionDao;
        }

        @RequestMapping(path = "/collections", method = RequestMethod.GET)
    public List<Collection> showMyCollections(Principal principal) {
            return this.collectionDao.getCollectionsByUsername(principal.getName());
        }


    }
