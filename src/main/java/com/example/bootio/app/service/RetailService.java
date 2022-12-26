package com.example.bootio.app.service;

import com.example.bootio.app.model.RetailInterface;
import com.example.bootio.app.repository.JpaRetailRepository;
import com.example.bootio.app.repository.RetailRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class RetailService {
    @Resource(name="retailRepository")
    private RetailRepository retailRepository;

    @Resource(name="jpaRetailRepository")
    private JpaRetailRepository jpaRetailRepository;

    public List<?> findService(LocalDate date) {
        return retailRepository.findAll();
    }

    public List<RetailInterface> findAll(LocalDate date) {
        return jpaRetailRepository.findAllWM();
    }
}
