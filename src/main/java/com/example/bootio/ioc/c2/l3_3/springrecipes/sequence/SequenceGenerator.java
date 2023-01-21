package com.example.bootio.ioc.c2.l3_3.springrecipes.sequence;

import com.example.bootio.ioc.c2.l3_1.sequence.PrefixGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
  //  @Autowired
    private PrefixGenerator[] prefixGenerators;
    private String suffix;
    private int initial;
    private AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {
    }


    public SequenceGenerator(PrefixGenerator[] prefixGenerators, String suffix, int initial) {
        this.prefixGenerators = prefixGenerators;
        this.suffix = suffix;
        this.initial = initial;
    }

    @Autowired
    public void setPrefixGenerators(PrefixGenerator[] prefixGenerators) {
        this.prefixGenerators = prefixGenerators;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        for (PrefixGenerator prefix :
                prefixGenerators) {
            System.out.println(prefix.getClass());
            builder.append(prefix.getPrefix());
            builder.append("-");
        }
        builder.append(initial).append(counter.getAndIncrement()).append(suffix);
        return builder.toString();
    }

}
