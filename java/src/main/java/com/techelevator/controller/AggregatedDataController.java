package com.techelevator.controller;

import com.techelevator.dao.AggregateDataDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.AggregatedDataDTO;
import com.techelevator.model.Record;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("permitAll")


public class AggregatedDataController {

    private UserDao userdao;
    private AggregateDataDao dao;

    public AggregatedDataController(AggregateDataDao dao) {
        this.dao = dao;
    }

    @GetMapping(path = "/data/site-stats")
    public AggregatedDataDTO getTotalNumberOfUsers() {
        AggregatedDataDTO siteStats = new AggregatedDataDTO();
        siteStats.setMemberCount(dao.getTotalNumberOfUsers());
        siteStats.setPremiumUserCount(dao.getTotalPremiumUsers());
        siteStats.setCollectionCount(dao.getTotalNumberOfCollections());
        siteStats.setRecordCount(dao.getTotalNumberOfRecord());
        siteStats.setAvgRecordsInCollection(dao.getAverageNumberOfRecordsInCollections());
        siteStats.setTopTenRecords(dao.getTopTenRecords());
        siteStats.setWorstRecord(dao.getLeastPopularRecord());
        siteStats.setTopArtist(dao.getMostPopularArtist());
        siteStats.setWorstArtist(dao.getLeastPopularArtist());
        siteStats.setTopRecord(dao.getMostPopularRecord());
        siteStats.setMostActiveUser(dao.getMostActiveUser());

        return siteStats;
    }


    @GetMapping(path = "/data/top-genre")
    public String getMostPopularGenre() {
        return this.dao.getMostPopularGenre();
    }

    @GetMapping(path = "/data/worst-genre")
    public String getLeastPopularGenre() {
        return this.dao.getLeastPopularGenre();
    }

    @GetMapping(path = "/data/search-tags/public")
    public List<Record> searchPublicTags(@RequestParam(required = false) String searchword) {
        if (this.dao.searchTagsPublic(searchword) != null) {
            return this.dao.searchTagsPublic(searchword);
        } else {
            throw new DataSourceLookupFailureException("No columns found at this time.");
        }
    }

    @GetMapping(path = "/data/search-tags/private")
    public List<Record> searchPersonalTags(@RequestParam(required = false) String searchword, Principal principal) {
        List<Record> publicSearch = this.dao.searchTagsThroughPersonalCollection(searchword, userdao.findIdByUsername(principal.getName()));
        if (publicSearch != null) {
            return publicSearch;
        } else {
            throw new DataSourceLookupFailureException("Information Cannot Be Found");
        }
    }

    @GetMapping(path = "/data/top-record-artist")
    public Record getMostPopularRecordByArtist(@RequestParam("artistName") String artistName) {
        return this.dao.mostPopularRecordByArtist(artistName);
    }

    @GetMapping(path = "/data/top-ten-records")
    public List<Record> getTopTenRecords() {
        return this.dao.getTopTenRecords();
    }


}
