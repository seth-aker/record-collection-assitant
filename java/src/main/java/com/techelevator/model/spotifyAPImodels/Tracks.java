package com.techelevator.model.spotifyAPImodels;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

    public class Tracks {

        private String href;
        private int limit;
        private int total;

        @JsonAlias(value = "items")
        private List<TrackInfo> trackInfo;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<TrackInfo> getTrackInfo() {
            return trackInfo;
        }

        public void setItems(List<TrackInfo> trackInfo) {
            this.trackInfo = trackInfo;
        }

    }