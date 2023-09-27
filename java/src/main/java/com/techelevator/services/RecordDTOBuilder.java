package com.techelevator.services;

import com.techelevator.dao.*;
import com.techelevator.model.*;

import java.util.ArrayList;
import java.util.List;

public class RecordDTOBuilder {


    private RecordDao recordDao;
    private ArtistDao artistDao;
    private GenreDao genreDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    public RecordDTOBuilder(RecordDao recordDao,
                            ArtistDao artistDao,
                            GenreDao genreDao,
                            LabelDao labelDao,
                            TrackDao trackDao)
    {
        this.recordDao = recordDao;
        this.artistDao = artistDao;
        this.genreDao = genreDao;
        this.labelDao = labelDao;
        this.trackDao = trackDao;

    }

    public RecordDTO getRecordById(String recordId) {
        Record record = this.recordDao.getRecordById(recordId);
        List<Artist> artists = this.artistDao.getRecordArtists(recordId);
        List<Genre> genres = new ArrayList<>();
        for (Artist artist : artists) {
            genres.addAll(this.genreDao.getArtistGenres(artist.getArtistId()));
        }
//        Label recordLabel = this.labelDao.getRecordLabel(recordId);
//        List<Track> tracks = this.trackDao.getRecordTracks(recordId);

//        return new RecordDTO(record, artists, genres, recordLabel, tracks);
        return null;
    }

    public boolean addRecordToDb(RecordDTO recordDTO, String recordId, int userId) {

        boolean recordAdded = recordDao.createRecord(recordId, recordDTO.getRecord().getTitle());
        boolean noteAdded;
        if(recordAdded) {
          noteAdded = recordDao.updateRecordNote(recordId, userId, recordDTO.getRecord().getUserNote());
        }

//        boolean artistsAdded = artistDao.addArtist
        return false;
    }

    public boolean addRecordToDb(RecordDTO recordDTO, int userId) {
//       if(recordDao.addRecordToUserLib(recordDTO.getRecord(), userId)) {
//
//       }
        return false;
    }
}
