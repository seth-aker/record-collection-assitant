package com.techelevator.services.spotifyAPI;

import com.techelevator.model.discogs.SearchResponse;
import com.techelevator.model.spotifyAPImodels.AlbumSearchResponse;
import com.techelevator.model.RecordDTO;
import com.techelevator.model.spotifyAPImodels.SpotifyResponse;
import com.techelevator.model.spotifyAPImodels.TokenResponse;
import com.techelevator.services.APIService;
import com.techelevator.services.RecordDTOBuilder;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SpotifyAPIService implements APIService {

    private static String API_BASE_URL = "https://api.spotify.com/v1";
    private final RestTemplate restTemplate = new RestTemplate();
    private String token;
    private static String API_TOKEN_URL = "https://accounts.spotify.com/api/token";
    private LocalDateTime tokenLastUpdated;

    public SpotifyAPIService() {
        setAccessToken();
    }

    @Override
    public RecordDTO getRecordInformation(String recordId) {
        SpotifyResponse spotifyResponse = new SpotifyResponse();

        //Checks if the access token for spotify has been updated within the last hour. If not, then updates the token.
        Duration duration = Duration.between(tokenLastUpdated, LocalDateTime.now());
        if(duration.getSeconds() > 3600) {
            setAccessToken();
        }

        HttpEntity<Void> request = createSpotifyRequest();

        try {
            ResponseEntity<SpotifyResponse> spotifyResponseEntity = restTemplate.exchange(API_BASE_URL + "/albums/"+ recordId, HttpMethod.GET, request, SpotifyResponse.class);
            spotifyResponse = spotifyResponseEntity.getBody();

        } catch (RestClientResponseException e) {
            String errorMessage = "Return status: " + e.getRawStatusCode() + "\n" +
                    "Status message: " + e.getMessage();
            System.out.println(errorMessage);

        } catch (ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);

        } catch (NullPointerException e) {
            System.out.println("Error, no response from Spotify.");

        }
        return createRecordDTO(spotifyResponse);
    }

    @Override
    public SearchResponse getAlbumSearch(String query, int perPage, String type, int page, String genre) {
        List<RecordDTO> spotifyResponse = new ArrayList<>();

        //Checks if the access token for spotify has been updated within the last hour. If not, then updates the token.
        Duration duration = Duration.between(tokenLastUpdated, LocalDateTime.now());
        if(duration.getSeconds() > 3600) {
            setAccessToken();
        }

        HttpEntity<Void> request = createSpotifyRequest();
        List<SpotifyResponse> albums = new ArrayList<>();
        try {
            ResponseEntity<AlbumSearchResponse> response = restTemplate.exchange(API_BASE_URL +"/search?q=" + query, HttpMethod.GET, request, AlbumSearchResponse.class);
            AlbumSearchResponse albumSearchResponse = response.getBody();
            albums = albumSearchResponse.getSpotifyResponses();
        }catch (RestClientResponseException e) {
            String errorMessage = "Return status: " + e.getRawStatusCode() + "\n" +
                    "Status message: " + e.getMessage();
            System.out.println(errorMessage);

        } catch (ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);

        } catch (NullPointerException e) {
            System.out.println("Error, no response from Spotify.");
        }

        for(SpotifyResponse album : albums) {
            spotifyResponse.add(createRecordDTO(album));
        }
        return null;
    }

    @Override
    public SearchResponse getArtistSearch(String searchString) {
        List<RecordDTO> searchResults = new ArrayList<>();

        Duration duration = Duration.between(tokenLastUpdated, LocalDateTime.now());
        if(duration.getSeconds() > 3600) {
            setAccessToken();
        }
        HttpEntity<Void> request = createSpotifyRequest();


        return null;
    }

    private void setAccessToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> tokenRequestBody = new LinkedMultiValueMap<>();
        tokenRequestBody.add("grant_type", "client_credentials");
        tokenRequestBody.add("client_id", System.getenv("CLIENT_ID"));
        tokenRequestBody.add("client_secret", System.getenv("CLIENT_SECRET"));
        TokenResponse response = new TokenResponse();

        try {
            response = restTemplate.postForObject(API_TOKEN_URL, new HttpEntity<>(tokenRequestBody, headers), TokenResponse.class);
            this.token = response.getAccessToken();
        } catch (RestClientResponseException e) {
            String errorMessage = "Return status: " + e.getRawStatusCode() + "\n" +
                    "Status message: " + e.getMessage();
            System.out.println(errorMessage);

        } catch (ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);

        } catch (NullPointerException e) {
            System.out.println("Error, no response from Spotify.");

        } catch (Exception e) {
            System.out.println("Something went wrong. " + e.getMessage());
        }

        this.tokenLastUpdated = LocalDateTime.now();
    }



    private HttpEntity<Void> createSpotifyRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(this.token);
        return new HttpEntity<>(null, headers);
    }

    //The record DTO builder is no longer in use. If we want to get the spotify API working again it needs major changes
    private RecordDTO createRecordDTO(SpotifyResponse spotifyResponse) {
        RecordDTOBuilder recordDTOBuilder = new RecordDTOBuilder();
        return recordDTOBuilder.createRecordDTO(spotifyResponse);
    }

}
