package com.techelevator.controller;

import com.techelevator.dao.AggregateDataDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Record;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;



@RestController
@CrossOrigin
@PreAuthorize("permitAll")


public class AggregatedDataController {

    private UserDao userdao;
    private AggregateDataDao dao;

    public AggregatedDataController(AggregateDataDao dao){
        this.dao = dao;
    }
    @GetMapping(path = "/data/total-users")
    public int getTotalNumberOfUsers(){
        return this.dao.getTotalNumberOfUsers();
    }
    @GetMapping(path = "/data/top-record")
    public Record getMostPopularRecord(){
        return this.dao.getMostPopularRecord();
    }
    @GetMapping(path = "/data/worst-record")
    public Record getLeastPopularRecord(){
        return this.dao.getLeastPopularRecord();
    }

    @GetMapping(path = "/data/total-records")
    public int getTotalNumberOfRecords(){
        return this.dao.getTotalNumberOfRecord();
    }

    @GetMapping(path = "/data/total-collections")
    public int getTotalCollections(){
        return this.dao.getTotalNumberOfCollections();
    }

    @GetMapping(path = "/data/total-premium-users")
    public int getTotalPremiumUsers(){
        return this.dao.getTotalPremiumUsers();
    }

    @GetMapping(path = "/data/records-per-collection")
    public double getAvgRecordsInCollection(){
        return this.dao.getAverageNumberOfRecordsInCollections();
    }

    @GetMapping(path = "/data/top-artist")
    public String getMostPopularArtist(){
        return this.dao.getMostPopularArtist();
    }

    @GetMapping(path = "/data/worst-artist")
    public String getLeastPopularArtist(){
        return this.dao.getLeastPopularArtist();
    }
    @GetMapping(path = "/data/top-ten-artists")
    public List<String> getTopTenArtists(){
        return this.dao.getTopTenArtists();
    }

    @GetMapping(path = "/data/most-active-user")
    public String getMostActiveUser(){
        return this.dao.getMostActiveUser();
    }
    @GetMapping(path = "/data/top-genre")
    public String getMostPopularGenre(){
        return this.dao.getMostPopularGenre();
    }
    @GetMapping(path = "/data/worst-genre")
    public String getLeastPopularGenre(){
        return this.dao.getLeastPopularGenre();
    }
    @GetMapping(path = "/data/search-tags/public")
    public List<Record> searchPublicTags(@RequestParam(required = false)String searchword){
        if(this.dao.searchTagsPublic(searchword)!=null){
            return this.dao.searchTagsPublic(searchword);
        }else{
            throw new DataSourceLookupFailureException("Information Cannot Be Found");
        }
    }

    @GetMapping(path = "/data/search-tags/private")
    public List<Record> searchPersonalTags(@RequestParam(required = false)String searchword, Principal principal){
        List<Record> publicSearch = this.dao.searchTagsThroughPersonalCollection(searchword, userdao.findIdByUsername(principal.getName()));
        if(publicSearch != null){
            return publicSearch;
        }else{
            throw new DataSourceLookupFailureException("Information Cannot Be Found");

        }
    }

    @GetMapping(path = "/data/top-record-artist")
    public Record getMostPopularRecordByArtist(@RequestParam("artistName") String artistName){
        return this.dao.mostPopularRecordByArtist(artistName);
    }
    @GetMapping(path = "/data/top-ten-records")
    public List<Record> getTopTenRecords(){
        return this.dao.getTopTenRecords();
    }



}
