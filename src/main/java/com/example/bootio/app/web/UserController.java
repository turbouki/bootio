package com.example.bootio.app.web;

import com.example.bootio.app.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {
    @PostMapping("/users")
    public ResponseEntity<Void> addUser(final @RequestBody @Valid User user) {
        System.out.println(user);
        return ResponseEntity.noContent().build();
    }
}
