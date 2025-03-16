package com.lft.spring.entity.impl;

import com.lft.spring.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Battery extends Product {
    private boolean rechargeable;

    public Battery(String name, double price) {
        super(name, price);
    }
}