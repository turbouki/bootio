package com.example.bootio.app.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity(name = "retail_sales")
@Table(name="retail_sales")
//@NamedNativeQuery(name="RetailSales.findAllWM",
//query="select  cast(date_part('year', sales_month) as int) as sales_year " +
//        ",sum(case when kind_of_business = 'Women''s clothing stores' " +
//        "  then sales " +
//        "  end)  women_sales " +
//        ",sum(case when kind_of_business = 'Men''s clothing stores' " +
//        "  then sales " +
//        "  end)  men_sales " +
//        " from retail_sales " +
//        " where kind_of_business in ('Men''s clothing stores', 'Women''s clothing stores')" +
//        " group by 1" +
//        " order by 1")
//@SqlResultSetMappings({
//        @SqlResultSetMapping(
//         name="RetailSales.findAllWM",
//         classes = {
//                @ConstructorResult(targetClass = com.example.bootio.app.model.RetailSales.class,
//                    columns = {
//                        @ColumnResult(name="sales_year", type=Integer.class),
//                        @ColumnResult(name="women_sales", type=BigInteger.class),
//                        @ColumnResult(name="men_sales", type=BigInteger.class),
//                })
//        })
//})
public class RetailSales {
    @EmbeddedId
    private TestPrimaryKey id;
    private LocalDate sales_month;
    private String naics_code;
    private String kind_of_business;
    private String reason_for_null;
    private BigInteger sales;


//    public RetailSales(Integer salesYear, BigInteger womenSales, BigInteger menSales) {
//        this.salesYear = salesYear;
//        this.womenSales = womenSales;
//        this.menSales = menSales;
//    }
//
//    @EmbeddedId
//    private TestPrimaryKey id;
//
//    @Transient
//    @Column(name="sales_year")
//    private Integer salesYear;
//
//    @Transient
//    @Column(name="women_sales")
//    private BigInteger womenSales;
//
//    @Transient
//    @Column(name="men_sales")
//    private BigInteger menSales;
//
//
//    public RetailSales() {
//    }
}
