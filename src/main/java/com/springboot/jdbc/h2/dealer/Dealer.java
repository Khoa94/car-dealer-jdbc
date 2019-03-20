package com.springboot.jdbc.h2.dealer;

import lombok.Data;

@Data
public class Dealer {
    int id;
    String name;

    public Dealer(String name){
        this.name = name;
    }
}
