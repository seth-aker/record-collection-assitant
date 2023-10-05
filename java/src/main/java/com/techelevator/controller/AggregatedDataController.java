package com.techelevator.controller;

import com.techelevator.dao.AggregateDataDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.DataStatsDTO;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;
import com.techelevator.services.APIService;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@CrossOrigin
@PreAuthorize("permitAll")


public class AggregatedDataController {

    private UserDao userdao;
    private AggregateDataDao statsdao;
    private RecordDao recordDao;
    private APIService apiService;


    public AggregatedDataController(AggregateDataDao dao, UserDao userDao, RecordDao recordDao) {
        this.statsdao = dao;
        this.userdao = userDao;
    }

    @GetMapping(path = "/data/site-stats")
    public DataStatsDTO getTotalNumberOfUsers() {
        return this.statsdao
    }


    @GetMapping(path = "/data/search-tags/public")
    public DataStatsDTO searchPublicTags(@RequestParam(required = false) String searchword) {
        DataStatsDTO searchResult = new DataStatsDTO();
        if (this.statsdao.searchTagsPublic(searchword) != null) {
            searchResult.setPublicSearchTags(statsdao.searchTagsPublic(searchword));
            return searchResult;
        } else {
            throw new DataSourceLookupFailureException("No columns found at this time.");
        }
    }

    @GetMapping(path = "/data/search-tags/private")
    public DataStatsDTO searchPersonalTags(@RequestParam(required = false) String searchword, Principal principal) {
        DataStatsDTO selfSearch = new DataStatsDTO();
        int userId = userdao.findIdByUsername(principal.getName());
        if (this.statsdao.searchTagsThroughPersonalCollection(searchword, userId) != null) {
            selfSearch.setPrivateSearchTags(statsdao.searchTagsThroughPersonalCollection(searchword, userId));
            return selfSearch;
        } else {
            throw new DataSourceLookupFailureException("No columns found at this time.");
        }
    }

}
    public RecordDTO mapRowToData(DataStatsDTO siteStats) {
        siteStats.setMostActiveUser(statsdao.getMostActiveUser());
        siteStats.setMemberCount(statsdao.getTotalNumberOfUsers());
        siteStats.setPremiumUserCount(statsdao.getTotalPremiumUsers());
        siteStats.setCollectionCount(statsdao.getTotalNumberOfCollections());
        siteStats.setRecordCount(statsdao.getTotalNumberOfRecord());
        siteStats.setAvgRecordsInCollection(statsdao.getAverageNumberOfRecordsInCollections());


        return siteStats;
    }


    public DataStatsDTO mapRowToData(DataStatsDTO dataStatsDTO) {
        DataStatsDTO siteStats = new DataStatsDTO();
        siteStats.setMostActiveUser(statsdao.getMostActiveUser());
        siteStats.setMemberCount(statsdao.getTotalNumberOfUsers());
        siteStats.setPremiumUserCount(statsdao.getTotalPremiumUsers());
        siteStats.setCollectionCount(statsdao.getTotalNumberOfCollections());
        siteStats.setRecordCount(statsdao.getTotalNumberOfRecord());
        siteStats.setAvgRecordsInCollection(statsdao.getAverageNumberOfRecordsInCollections());


        siteStats.setTopTenRecords(statsdao.getTopTenRecords());
        siteStats.setTopTenArtists(statsdao.topTenArtists());
        siteStats.setTopArtist(statsdao.getMostPopularArtist());
        siteStats.setTopRecord(statsdao.getMostPopularRecord());

        siteStats.setWorstArtist(statsdao.getLeastPopularArtist());
        siteStats.setWorstRecord(statsdao.getLeastPopularRecord());
        siteStats.setWorstGenre(statsdao.getLeastPopularGenre());

        siteStats.setTopGenre(statsdao.getMostPopularGenre());

        return siteStats;
    }
}
