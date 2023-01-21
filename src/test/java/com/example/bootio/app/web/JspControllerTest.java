package com.example.bootio.app.web;

import com.example.bootio.app.model.User;
import com.example.bootio.app.model.UserRole;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // https://ssons.tistory.com/63 역할 잠조
@WebMvcTest(JspController.class)
public class JspControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //    @DisplayName(("사용차 추가 실패 - 유효하지 않은 (최저)나이 "))
    @Test
    public void addUserFailUnderAge() throws Exception {
        final User user = User.builder()
                .email("tu@daum.net")
                .pw("test")
                .userRole(UserRole.USER)
                .age(10).build();

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/user/addJson")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }


}
