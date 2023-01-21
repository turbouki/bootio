package com.example.bootio.ioc.c2.l3_1.shop.config;

import com.example.bootio.ioc.c2.l3_1.shop.Disc;
import com.example.bootio.ioc.c2.l3_1.shop.Battery;
import com.example.bootio.ioc.c2.l3_1.shop.Product;
import org.springframework.context.annotation.Bean;

public class ShopConfiguration {
    @Bean
    public Product aaa() {
        Battery p1 = new Battery("AAA", 2.5);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc();
        p2.setCapacity(700);
        return p2;
    }

}
