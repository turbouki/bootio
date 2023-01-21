package com.example.bootio.ioc.c2.l3_1.config;

import com.example.bootio.ioc.c2.l3_1.sequence.DatePrefixGenerator;
import com.example.bootio.ioc.c2.l3_1.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceGeneratorConfiguration {
//    @Bean
//    public SequenceGenerator sequenceGenerator() {
//        SequenceGenerator seqgen = new SequenceGenerator();
//        seqgen.setPrefix("30");
//        seqgen.setSuffix("A");
//        seqgen.setInitial(100000);
//        return seqgen;
//    }
    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator dpg = new DatePrefixGenerator();
        dpg.setPattern("yyyyMMdd");
        return dpg;
    }

    @Bean
    SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(100000);
        sequence.setSuffix("A");
        sequence.setPrefixGenerator(datePrefixGenerator());
        return sequence;
    }
}
