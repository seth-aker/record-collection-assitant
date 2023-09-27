package com.techelevator.model;

import java.util.List;

    public class Tracks {

        private String href;
        private int limit;
        private String next;
        private int offset;
        private String previous;
        private int total;
        private List<TrackInfo> tracks;

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

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<TrackInfo> getTrackInfo() {
            return tracks;
        }

        public void setItems(List<TrackInfo> trackInfo) {
            this.tracks = tracks;
        }

    }