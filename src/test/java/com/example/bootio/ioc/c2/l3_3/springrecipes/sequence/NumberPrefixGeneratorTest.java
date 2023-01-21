package com.example.bootio.ioc.c2.l3_3.springrecipes.sequence;

import com.example.bootio.ioc.c2.l3_1.sequence.PrefixGenerator;
import org.junit.Test;

public class NumberPrefixGeneratorTest {

    @Test
    public void getValue() {
        PrefixGenerator generator = new NumberPrefixGenerator();
        System.out.println(generator.getPrefix());
    }

}
