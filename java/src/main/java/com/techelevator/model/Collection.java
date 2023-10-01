package com.techelevator.model;

import java.util.List;

public class Collection {

    private int id;
    private int userId;
    private String username;
    private String name;
    private boolean isPublic;
    private List<String> recordIds;

    public Collection() {
    }

    public Collection(int id, String name, boolean isPublic, int userId) {
        this.id = id;
        this.name = name;
        this.isPublic = isPublic;
        this.userId = userId;
    }

    public Collection(int id, int userId, String name, boolean isPublic, List<String> recordIds) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.isPublic = isPublic;
        this.recordIds = recordIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public List<String> getRecordIds() {
        return recordIds;
    }

    public void setRecordIds(List<String> recordIds) {
        this.recordIds = recordIds;
    }
}
