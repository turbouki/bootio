package com.example.bootio.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestJspController {
    @GetMapping("test/jsp")
    public String index() {
        return "test";
    }

    @GetMapping("data/jsp")
    public String api() {
        return "data";
    }
}
