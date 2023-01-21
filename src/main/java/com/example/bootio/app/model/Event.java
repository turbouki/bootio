package com.example.bootio.app.model;

import lombok.ToString;

@ToString
public class Event {
    Integer id;

    public Event(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
