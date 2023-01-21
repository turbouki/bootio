package com.example.bootio.ioc.c2.l8_1.springrecipes.shop.config;

import com.example.bootio.ioc.c2.l8_1.springrecipes.shop.Battery;
import com.example.bootio.ioc.c2.l8_1.springrecipes.shop.Cashier;
import com.example.bootio.ioc.c2.l8_1.springrecipes.shop.Disc;
import com.example.bootio.ioc.c2.l8_1.springrecipes.shop.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.bootio.ioc.c2.l8_1.springrecipes.shop")
public class ShoppingConfiguration {

    @Bean
    public Product aaa() {
        Battery p1 = new Battery();
        p1.setName("AAA");
        p1.setPrice(2.5);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DBD-RW", 3.0);
        p2.setCapacity(700);
        return p2;
    }

    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier() {
        String path = System.getProperty("java.io.tmpdir") + "/cashier";
        Cashier c1 = new Cashier();
        System.out.println(path);
        c1.setFileName("checkout");
        c1.setPath(path);
        return c1;
    }
}
