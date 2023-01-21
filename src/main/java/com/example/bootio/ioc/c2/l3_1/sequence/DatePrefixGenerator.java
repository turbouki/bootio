package com.example.bootio.ioc.c2.l3_1.sequence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrefixGenerator implements PrefixGenerator{

    private DateFormat fomatter;

    public void setPattern(String pattern) {
        this.fomatter = new SimpleDateFormat(pattern);
    }
    @Override
    public String getPrefix() {
        return fomatter.format(new Date());
    }
}
