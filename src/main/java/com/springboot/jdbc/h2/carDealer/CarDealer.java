package com.springboot.jdbc.h2.carDealer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDealer {
    int carId;
    int dealerId;
    int availableCount;
    int requestCount;
}
