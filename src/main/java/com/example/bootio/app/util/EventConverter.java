package com.example.bootio.app.util;

import com.example.bootio.app.model.Event;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//@Component
public class EventConverter implements Converter<String, Event> {

    @Override
    public Event convert(String value) {
        return new Event(Integer.parseInt(value));
    }
}
