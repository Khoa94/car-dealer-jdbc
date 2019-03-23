package com.springboot.jdbc.h2.dealer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dealer {
    int id;
    String name;

    public Dealer(String name){
        this.name = name;
    }
}
