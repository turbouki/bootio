package com.example.bootio.app.web;

import com.example.bootio.app.util.EventFormatter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// https://velog.io/@jaden_94/Spring-%EC%9D%98-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B0%94%EC%9D%B8%EB%94%A9
@SpringBootTest
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = {EventController.class, EventFormatter.class})
//@WebMvcTest
class EventControllerPropertyEditorTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getEvent() throws Exception {
        mockMvc.perform(get("/event/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }


}
