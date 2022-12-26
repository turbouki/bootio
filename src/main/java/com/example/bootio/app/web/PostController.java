package com.example.bootio.app.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class PostController {
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
