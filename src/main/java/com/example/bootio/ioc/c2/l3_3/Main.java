package com.example.bootio.ioc.c2.l3_3;

import com.example.bootio.ioc.c2.l3_3.config.SequenceConfiguration;
import com.example.bootio.ioc.c2.l3_3.springrecipes.sequence.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceConfiguration.class);
        SequenceGenerator generator = context.getBean(SequenceGenerator.class);

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
    }
}
