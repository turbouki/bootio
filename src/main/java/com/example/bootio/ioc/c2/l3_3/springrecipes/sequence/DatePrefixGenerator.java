package com.example.bootio.ioc.c2.l3_3.springrecipes.sequence;

import com.example.bootio.ioc.c2.l3_1.sequence.PrefixGenerator;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrefixGenerator implements PrefixGenerator {
    private DateFormat formatter;

    public void setPattern(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }
    @Override
    public String getPrefix() {
        return formatter.format(new Date());
    }
}
