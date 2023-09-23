package com.crio.jukebox.entites;

class BaseEntity {
    protected String id;

    BaseEntity(){}
    public BaseEntity(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
