package com.example.bootio.app.util;

import com.example.bootio.app.model.Event;

import java.beans.PropertyEditorSupport;

public class EventPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Event event = new Event(Integer.parseInt(text));
        setValue(event);
    }

}
