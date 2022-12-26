package com.example.bootio.app.service;

import com.example.bootio.app.repository.DataRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

//@RequiredArgsConstructor
@Service
public class DataService {

    @Resource(name="dataRepository")
    private DataRepository dataRepository;
    //private final DataRepository dataRepository;

//    public DataService(DataRepository dataRepository) {
//        this.dataRepository = dataRepository;
//    }

    public List<?> findAll(LocalDate date) {
        return dataRepository.findAll();
    }
}
