package com.techelevator.model;

public class Collection {

    private int id;
    private int userId;
    private String name;
    private boolean isPublic;

    public Collection() {
    }

    public Collection(int id, String name, boolean isPublic, int userId) {
        this.id = id;
        this.name = name;
        this.isPublic = isPublic;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
