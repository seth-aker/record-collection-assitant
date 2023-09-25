package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")

public class CollectionController {
        private CollectionDao collectionDao;


        public CollectionController(CollectionDao collectionDao) {
            this.collectionDao = collectionDao;
        }


    }
