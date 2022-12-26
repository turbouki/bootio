package com.example.bootio.app.service;

import com.example.bootio.app.model.Usr;
import com.example.bootio.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository todoRepository;

    public List<Usr> findAll() {
        return  todoRepository.findAll();
    }
}
