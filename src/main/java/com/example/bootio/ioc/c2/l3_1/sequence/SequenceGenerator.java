package com.example.bootio.ioc.c2.l3_1.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
    //private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    private PrefixGenerator prefixGenerator;

    public SequenceGenerator() {
    }

    public SequenceGenerator(String suffix, int initial, PrefixGenerator prefixGenerator) {
        this.suffix = suffix;
        this.initial = initial;
        this.prefixGenerator = prefixGenerator;
    }

//    public void setPrefix(String prefix) {
//        this.prefix = prefix;
//    }

    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

//    public String getSequence() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(prefix)
//                .append(initial)
//                .append(counter.getAndIncrement())
//                .append(suffix);
//
//        return builder.toString();
//    }

    public String getSequence() {
        String builder = prefixGenerator.getPrefix() +
                initial +
                counter.getAndIncrement() +
                suffix;
        return builder;
    }
}
