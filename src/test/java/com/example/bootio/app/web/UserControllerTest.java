package com.example.bootio.app.web;

import com.example.bootio.app.model.User;
import com.example.bootio.app.model.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sun.reflect.annotation.ExceptionProxy;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("사용자 추가 실패 - 이메일 형식이 아님")
    @Test
    void addUserFailNotEmailFormat() throws Exception {
        final User user = User.builder()
                .email("hi")
                .pw("kk")
                .userRole(UserRole.USER)
                .age(28).build();

        System.out.println(new ObjectMapper().writeValueAsString(user));

        final ResultActions resultActions = mockMvc.perform(
                        MockMvcRequestBuilders.post("/users")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }
}
