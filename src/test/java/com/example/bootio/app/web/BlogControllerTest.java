package com.example.bootio.app.web;

import com.example.bootio.app.model.Info;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// https://shinsunyoung.tistory.com/52
@RunWith(SpringRunner.class)
@WebMvcTest(BlogController.class)
public class BlogControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_get() throws Exception {
        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
        info.add("name", "칩");
        info.add("id", "chip");
     //   System.out.println("Tets ==========================");
        mockMvc.perform(get("/blog")
                .params(info))
                .andExpect(status().isOk())
                .andExpect(content().string("칩의 블로그입니다. chip"))
                .andDo(print());
    }

    @Test
    public void test_post() throws Exception {
        String content = objectMapper.writeValueAsString(new Info("데일", "dale"));
        mockMvc.perform(post("/blog")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(content().string("데일의 블로그입니다. dale"))
                .andDo(print());
    }


}
