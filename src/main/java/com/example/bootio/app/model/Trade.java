package com.example.bootio.app.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Trade {
    private int id;
    private int  quantity;
    private String account;
    private String security;
    private String status;
    private String direction;
}
