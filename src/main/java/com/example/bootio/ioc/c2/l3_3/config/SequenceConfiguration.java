package com.example.bootio.ioc.c2.l3_3.config;

import com.example.bootio.ioc.c2.l3_1.sequence.DatePrefixGenerator;
import com.example.bootio.ioc.c2.l3_3.springrecipes.sequence.NumberPrefixGenerator;
import com.example.bootio.ioc.c2.l3_3.springrecipes.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceConfiguration {

    @Bean
    public NumberPrefixGenerator numberPrefixGenerator() {
        return new NumberPrefixGenerator();
    }
    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator dpg = new DatePrefixGenerator();
        dpg.setPattern("yyyyMMdd");
        return dpg;
    }
    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(10000);
        sequence.setSuffix("A");
        return sequence;
    }
}
