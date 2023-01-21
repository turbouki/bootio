package com.example.bootio.app.config;

import com.example.bootio.app.util.EventConverter;
import com.example.bootio.app.web.EventController;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 스프링 부트에서는 Converter를 빈으로 등록하기만 하면 알아서, FormatterRegistry에 해당 컨버터를 추가해서 사용할 수 있게 해주지만
    // 스프링 부트가 아닌 스프링의 경우 그런 기능이 없기 때문에 직접 설정해 주어야 한다.
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new EventConverter());
    }
}
