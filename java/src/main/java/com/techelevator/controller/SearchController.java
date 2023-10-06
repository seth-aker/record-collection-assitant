package com.techelevator.controller;

import com.techelevator.model.discogs.SearchResponse;
import com.techelevator.services.APIService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SearchController {

    private APIService apiService;

    public SearchController(APIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(path = "/search")
    public SearchResponse getRecordSearchResults(@RequestParam(defaultValue = "") String q,
                                                 @RequestParam (defaultValue = "25" ) int per_page,
                                                 @RequestParam (defaultValue = "release") String type,
                                                 @RequestParam (defaultValue = "1" ) int page,
                                                 @RequestParam (defaultValue = "") String genre) {
        return apiService.getAlbumSearch(q, per_page, type, page, genre);
    }

}
