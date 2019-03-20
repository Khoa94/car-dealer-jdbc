package com.springboot.jdbc.h2.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    int id;
    String make;
    String name;
    String color;

    public Car(String make, String name, String color){
        this.make = make;
        this.name = name;
        this.color = color;
    }
}
