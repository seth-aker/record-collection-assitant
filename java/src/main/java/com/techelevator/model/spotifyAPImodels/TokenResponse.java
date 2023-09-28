package com.techelevator.model.spotifyAPImodels;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TokenResponse {
    @JsonAlias(value ="access_token")
    String accessToken;

    @JsonAlias(value = "token_type")
    String tokenType;

    @JsonAlias(value = "expires_in")
    String expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}

