package com.example.bootio.ioc.c2.l6_2.springrecipes.shop;

import com.example.bootio.ioc.c2.l6_2.springrecipes.shop.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ShoppingCart {
    private List<com.example.bootio.ioc.c2.l6_2.springrecipes.shop.Product> items = new ArrayList<>();

    public void addItem(com.example.bootio.ioc.c2.l6_2.springrecipes.shop.Product item) {
        items.add(item);
    }
    public List<Product> getItems() {
        return items;
    }
 }
