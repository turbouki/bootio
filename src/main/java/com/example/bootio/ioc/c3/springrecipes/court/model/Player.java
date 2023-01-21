package com.example.bootio.ioc.c3.springrecipes.court.model;

public class Player {
    private String name;
    private String phone;

    public Player(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
