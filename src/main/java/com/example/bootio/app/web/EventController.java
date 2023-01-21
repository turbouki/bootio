package com.example.bootio.app.web;

import com.example.bootio.app.model.Event;
import com.example.bootio.app.util.EventPropertyEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

//    @InitBinder
//    public void init(WebDataBinder webDataBinder) {
//        webDataBinder.registerCustomEditor(Event.class, new EventPropertyEditor());
//    }
    @GetMapping("/event/{eventId}")
    public String getEvent(@PathVariable(value = "eventId") Event event) {
        return event.getId().toString();
    }
}
