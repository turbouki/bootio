package com.example.bootio.app.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController // @Controller + @ResponseBody
public class PostController {
    // JSON object를 그래도 받고 싶을때는 @RequestBody를 사용합니다.
    @PostMapping("/group")
    public GroupDto post(@RequestBody GroupDto groupDto) {
        log.debug(":: POST ================");
        log.debug(":: GroupDto {}", groupDto);
        return groupDto;
    }


    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    private static class GroupDto {
        private String groupName;
        private List<String> members;
        private DateObj date;

        @Setter
        @Getter
        @ToString
        @NoArgsConstructor
        private class DateObj {
            private int year;
            private int month;
            private int day;
        }
    }
}
