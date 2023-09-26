package com.techelevator.model;

public class Collection {

    private int id;
    private String name;
    private boolean isPublic;
    public Collection() {
    }

    public Collection(int id, String name, boolean isPublic) {
        this.id = id;
        this.name = name;
        this.isPublic = isPublic;
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
}
