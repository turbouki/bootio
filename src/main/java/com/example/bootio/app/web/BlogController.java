package com.example.bootio.app.web;

import com.example.bootio.app.model.Info;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
// class(=type)level
public class BlogController {

//    @InitBinder("targetDate")
//    public void initBinder(WebDataBinder binder) {
//        binder.addCustomFormatter(new DateFormatter("yyyyMMdd"));
//    }


    @PostMapping(value = "/blog/post/{postId}")
    public String blogWrite(@PathVariable String postId, @RequestParam String name, @RequestParam String id, @RequestParam String targetDate, Model model) {
        System.out.println(targetDate);
        System.out.println(model);
        System.out.println(postId);
        return "의 블로그입니다. " + postId;
    }

    @GetMapping(value = "/blog/post/{postId}")
    public String blogView(@PathVariable String postId, @RequestParam String name, Model model) {
//    public String blogWrite(@PathVariable String postId, @RequestParam String name, @RequestParam String id, @DateTimeFormat(pattern = "yyyyMMdd") @RequestParam String targetDate, Model model) {
        System.out.println(model);
        System.out.println(name);
        return "의 블로그입니다. " + postId;
    }

    @GetMapping(value = "/blog", headers = "X-Migration=true")
    public String blogGet(@RequestHeader("user-agent") String userAgent, @RequestParam String name, @RequestParam String id) {
        return name + "의 블로그입니다. " + id + userAgent;
    }

    @PostMapping(value = "/blog", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String blogPost(@RequestHeader("user-agent") String userAgent, @RequestBody Info info) {
        return info.getName()  + "의 블로그입니다. " + info.getId() + userAgent;
    }
    // method level
}
