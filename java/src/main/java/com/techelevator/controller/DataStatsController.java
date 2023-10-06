package com.techelevator.controller;

import com.techelevator.dao.DataStatsDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.DataStatsDTO;
import com.techelevator.model.Record;
import com.techelevator.services.APIService;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.nio.channels.ScatteringByteChannel;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("permitAll")
public class DataStatsController {

    private UserDao userdao;
    private DataStatsDao statsdao;
    private RecordDao recordDao;
    private APIService apiService;




    public DataStatsController(DataStatsDao statsDao, UserDao userDao, RecordDao recordDao) {
        this.statsdao = statsDao;
        this.userdao = userDao;
        this.recordDao = recordDao;
    }

    @GetMapping(path = "/site-stats")
    public DataStatsDTO getAllData() {
       return mapRowToData();
    }



    @RequestMapping(path = "/data/searchsearchword=")
    public List<Record> searchPublicTags(@RequestParam String searchword) {
        List<Record> addedRecords = new ArrayList<>();
         addedRecords = statsdao.searchTagsPublic(searchword);
         return addedRecords;
    }

        @RequestMapping(path = "/data/search-tags/private")
        public DataStatsDTO searchPersonalTags (@RequestParam String searchword, Principal principal){
            DataStatsDTO selfSearch = new DataStatsDTO();
            int userId = userdao.findIdByUsername(principal.getName());
            if (this.statsdao.searchTagsThroughPersonalCollection(searchword, userId) != null) {
                selfSearch.setPrivateSearchTags(statsdao.searchTagsThroughPersonalCollection(searchword, userId));
                return selfSearch;
            } else {
                throw new DataSourceLookupFailureException("No columns found at this time.");
            }
        }


        public DataStatsDTO mapRowToData (){
            DataStatsDTO siteStats = new DataStatsDTO();
            siteStats.setMemberCount(statsdao.getTotalNumberOfUsers());
            siteStats.setPremiumUserCount(statsdao.getTotalPremiumUsers());
            siteStats.setCollectionCount(statsdao.getTotalNumberOfCollections());
            siteStats.setRecordCount(statsdao.getTotalNumberOfRecord());
            siteStats.setAvgRecordsInCollection(statsdao.getAverageNumberOfRecordsInCollections());
            siteStats.setTopRecord(statsdao.getMostPopularRecord());
            siteStats.setTopTenRecords(statsdao.getTopTenRecords());
            siteStats.setTopTenArtists(statsdao.topTenArtists());
            siteStats.setTopArtist(statsdao.getMostPopularArtist());
            siteStats.setMostActiveUser(statsdao.getMostActiveUser());
            return siteStats;

        }



}