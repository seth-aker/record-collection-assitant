package com.techelevator.model.discogs;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Pagination {
    @JsonAlias(value = "per_page")
    private int perPage;
    private int pages;
    private int page;
    private Urls urls;
    private int items;

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

}
