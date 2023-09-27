package com.techelevator.services;

import com.techelevator.model.RecordDTO;
import com.techelevator.model.SpotifyResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class SpotifyAPIService implements APIService {

    private static String API_BASE_URL = "https://api.spotify.com/v1/albums/";
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
            ResponseEntity<SpotifyResponse> spotifyResponseEntity = restTemplate.exchange(API_BASE_URL + recordId, HttpMethod.GET, request, SpotifyResponse.class);
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

        } catch (Exception e) {
            System.out.println("Something went wrong. " + e.getMessage());
        }
        return createRecordDTO(spotifyResponse);
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

    private RecordDTO createRecordDTO(SpotifyResponse spotifyResponse) {
        RecordDTOBuilder recordDTOBuilder = new RecordDTOBuilder();
        return recordDTOBuilder.createRecordDTO(spotifyResponse);
    }

}
