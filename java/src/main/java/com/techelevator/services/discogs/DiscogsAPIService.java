package com.techelevator.services.discogs;


import com.techelevator.model.RecordDTO;
import com.techelevator.model.discogs.Release;
import com.techelevator.services.APIService;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


import java.util.List;

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
        return (RecordDTO) discogsResponse;

        }

    @Override
    public List<RecordDTO> getAlbumSearch(String searchString) {
        return null;
    }

    @Override
    public List<RecordDTO> getArtistSearch(String searchString) {
        return null;
    }

    private HttpEntity<Void> createDiscogsRequest() {
        final String authHeaderValue = "Discogs: key=" + System.getenv("DISCOGS_KEY") + ", secret=" + System.getenv("DISCOGS_SECRET");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", authHeaderValue );
        return new HttpEntity<>(null, headers);
    }


}
