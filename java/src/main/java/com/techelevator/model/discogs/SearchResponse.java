package com.techelevator.model.discogs;

import java.util.List;

public class SearchResponse {

        private Pagination pagination;

        private List<Result> results;

        public Pagination getPagination() {
            return pagination;
        }

        public void setPagination(Pagination pagination) {
            this.pagination = pagination;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

    }

