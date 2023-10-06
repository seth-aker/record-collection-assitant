package com.techelevator.services.discogs;



import com.techelevator.model.RecordDTO;
import com.techelevator.model.discogs.Release;
import com.techelevator.model.discogs.SearchResponse;
import com.techelevator.services.APIService;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;




@Component
public class DiscogsAPIService implements APIService {
    private static String API_BASE_URL = "https://api.discogs.com";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public RecordDTO getRecordInformation(String recordId) {
        Release discogsResponse = new Release();

        HttpEntity<Void> entity = createDiscogsRequest();

        try {
            ResponseEntity<Release>  releaseResponseEntity = restTemplate.exchange(API_BASE_URL + "/releases/" + recordId, HttpMethod.GET, entity, Release.class);
            discogsResponse = releaseResponseEntity.getBody();
        } catch (RestClientResponseException e) {
            String errorMessage = "Return status: " + e.getRawStatusCode() + "\n" +
                    "Status message: " + e.getMessage();
            System.out.println(errorMessage);
        } catch (ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
        }

        return  mapToRecordDTO(discogsResponse);

        }

    @Override
    public SearchResponse getAlbumSearch(String query, int perPage, String type, int page, String genre) {
        SearchResponse response = new SearchResponse();


        String searchUrl = API_BASE_URL + "/database/search?q=" + query + "&per_page=" + perPage + "&type=" + type + "&page=" + page + "&genre=" + genre;
        HttpEntity<Void> entity = createDiscogsRequest();
        try {
            ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, SearchResponse.class);
            response = responseEntity.getBody();
        } catch (RestClientResponseException e) {
            String errorMessage = "Return status: " + e.getRawStatusCode() + "\n" +
                    "Status message: " + e.getMessage();
            System.out.println(errorMessage);
        } catch (ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
        }
        return response;
    }

    @Override
    public SearchResponse getArtistSearch(String searchString) {
        return null;
    }

    private HttpEntity<Void> createDiscogsRequest() {
        final String authHeaderValue = "Discogs key=" + System.getenv("DISCOGS_KEY") + ", secret=" + System.getenv("DISCOGS_SECRET");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", authHeaderValue );
        return new HttpEntity<>(null, headers);
    }

    private RecordDTO mapToRecordDTO(Release release) {
        RecordDTO recordDTO = new RecordDTO();
        recordDTO.setTitle(release.getTitle());
        recordDTO.setId(release.getId());
        recordDTO.setArtists(release.getArtists());
        recordDTO.setThumb(release.getThumb());
        recordDTO.setCompanies(release.getCompanies());
        recordDTO.setCountry(release.getCountry());
        recordDTO.setDateAdded(release.getDateAdded());
        recordDTO.setDateChanged(release.getDateChanged());
        recordDTO.setEstimatedWeight(release.getEstimatedWeight());
        recordDTO.setExtraArtists(release.getExtraArtists());
        recordDTO.setFormatQuantity(release.getFormatQuantity());
        recordDTO.setFormats(release.getFormats());
        recordDTO.setGenres(release.getGenres());
        recordDTO.setIdentifiers(release.getIdentifiers());
        recordDTO.setImages(release.getImages());
        recordDTO.setLabels(release.getLabels());
        recordDTO.setLowestPrice(release.getLowestPrice());
        recordDTO.setMasterId(release.getMasterId());
        recordDTO.setMasterUrl(release.getMasterUrl());
        recordDTO.setNotes(release.getNotes());
        recordDTO.setReleased(release.getReleased());
        recordDTO.setReleasedFormatted(release.getReleasedFormatted());
        recordDTO.setSeries(release.getSeries());
        recordDTO.setStyles(release.getStyles());
        recordDTO.setTrackList(release.getTrackList());
        recordDTO.setUri(release.getUri());
        recordDTO.setVideos(release.getVideos());
        recordDTO.setYear(release.getYear());

        return recordDTO;
    }

}
