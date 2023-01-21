package com.example.bootio.ioc.c2.l6_2.springrecipes.shop.config;

import com.example.bootio.ioc.c2.l6_2.springrecipes.shop.Battery;
import com.example.bootio.ioc.c2.l6_2.springrecipes.shop.Disc;
import com.example.bootio.ioc.c2.l6_2.springrecipes.shop.Product;
import com.example.bootio.ioc.c2.l6_2.springrecipes.shop.BannerLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("com.example.bootio.ioc.c2.l6_2.springrecipes.shop")
public class ShoppingConfiguration {

    @Value("${specialcustomer.discount:0}")
    private double specialCustomerDiscountField;

    @Value("${summer.discount:0}")
    private double specialSummerDiscountField;

    @Value("${endofyear.discount:0}")
    private double specialEndofyearDiscountField;

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BannerLoader bannerLoader() {
        BannerLoader bl = new BannerLoader();
        bl.setBanner(banner);
        return bl;
    }
    @Bean
    public Product aaa() {
        Battery p1 = new Battery();
        p1.setName("AAA");
        p1.setPrice(2.5);
        p1.setRechargeable(true);
        p1.setDiscount(specialCustomerDiscountField);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 1.5, specialSummerDiscountField);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DBD-RW", 3.0, specialEndofyearDiscountField);
        p2.setCapacity(700);
        return p2;
    }
}
