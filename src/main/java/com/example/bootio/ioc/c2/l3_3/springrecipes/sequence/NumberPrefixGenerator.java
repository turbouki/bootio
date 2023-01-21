package com.example.bootio.ioc.c2.l3_3.springrecipes.sequence;

import com.example.bootio.ioc.c2.l3_1.sequence.PrefixGenerator;

import java.util.Random;

public class NumberPrefixGenerator implements PrefixGenerator {
    @Override
    public String getPrefix() {
        Random randomGenerator = new Random();
        System.out.println("getPrefix");
        int randomInt = randomGenerator.nextInt(100);
        return String.format("%03d", randomInt);
    }
}
