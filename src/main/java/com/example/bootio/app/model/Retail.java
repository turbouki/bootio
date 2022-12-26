package com.example.bootio.app.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Retail {
//    public Retail(Integer salesYear, BigInteger womenSales, BigInteger menSales) {
//        super();
//        this.salesYear = salesYear;
//        this.womenSales = womenSales;
//        this.menSales = menSales;
//    }

    private Integer salesYear;
    private BigInteger menSales;

    private BigInteger womenSales;


}
