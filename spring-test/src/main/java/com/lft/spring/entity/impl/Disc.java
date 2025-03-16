package com.lft.spring.entity.impl;

import com.lft.spring.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Disc extends Product {
    private int capacity;

    public Disc(String name, double price) {
        super(name, price);
    }
}