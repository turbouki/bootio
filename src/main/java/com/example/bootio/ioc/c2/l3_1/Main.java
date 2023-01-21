package com.example.bootio.ioc.c2.l3_1;

import com.example.bootio.ioc.c2.l3_1.sequence.SequenceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
//    public static void main(String[] args) {
//
//        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
//        SequenceGenerator generator = context.getBean(SequenceGenerator.class);
//
//        System.out.println(generator.getSequence());
//        System.out.println(generator.getSequence());
//    }
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.bootio.ioc.c2.sequence");

      //  SequenceDao sequenceDao = context.getBean(SequenceDao.class);
//        System.out.println(sequenceDao.getNextValue("IT"));
//        System.out.println(sequenceDao.getNextValue("IT"));

        SequenceService service = context.getBean(SequenceService.class);
        System.out.println(service.generator("IT"));
        System.out.println(service.generator("IT"));
    }
}
