package com.springboot.jdbc.h2.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    int id;
    String make;
    String name;

    public Car(String make, String name){
        this.make = make;
        this.name = name;
    }
}
