package com.example.bootio.ioc.c2.l7.springrecipes.shop;

import com.example.bootio.ioc.c2.l7.springrecipes.shop.config.ShoppingConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShoppingConfiguration.class);
        String alert = context.getMessage("alert.checkout", null, Locale.US);
        String alert_inventory = context.getMessage("alert.inventory.checkout",
                new Object[]{"[DVD-RW 3.0", new Date()}, Locale.US);
        System.out.println("The I18N message for alert.checkout is: " + alert);
        System.out.println("The I18N message for alert.inventory.checkout is : " + alert_inventory);

    }
}
