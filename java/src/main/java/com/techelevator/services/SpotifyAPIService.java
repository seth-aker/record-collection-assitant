package com.techelevator.services;

import com.techelevator.model.RecordDTO;
import com.techelevator.model.SpotifyResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class SpotifyAPIService implements APIService {

    private static String API_BASE_URL = "https://api.spotify.com/v1/albums/";
    private final RestTemplate restTemplate = new RestTemplate();
    private String userToken;

    @Override
    public RecordDTO getRecordInformation(String recordId) {
        SpotifyResponse spotifyResponse = new SpotifyResponse();


        HttpEntity<Void> request = createSpotifyRequest(userToken);

        try {
            spotifyResponse = restTemplate.postForObject(API_BASE_URL + recordId, request, SpotifyResponse.class);
        } catch (
                RestClientResponseException e) {
            String errorMessage = "Return status: " + e.getRawStatusCode() + "\n" +
                    "Status message: " + e.getMessage();
            System.out.println(errorMessage);

        } catch (
                ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);

        } catch (
                NullPointerException e) {
            System.out.println("Error, no response from Spotify.");

        } catch (
                Exception e) {
            System.out.println("Something went wrong. " + e.getMessage());
        }

        return createRecordDTO(spotifyResponse);

    }

    public void setUserToken(String token) {
        this.userToken = token;
    }

    private HttpEntity<Void> createSpotifyRequest(String userToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userToken);
        return new HttpEntity<>(null, headers);
    }

    private RecordDTO createRecordDTO(SpotifyResponse spotifyResponse) {
        RecordDTO recordDTO = new RecordDTO();
        return null;
    }
}
