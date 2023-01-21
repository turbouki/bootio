package com.example.bootio.ioc.c3.springrecipes.court.model;

public class SportType {
    private int id;
    private String name;

    public SportType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
