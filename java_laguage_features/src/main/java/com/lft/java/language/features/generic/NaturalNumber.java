package com.lft.java.language.features.generic;

/**
 * <T extends B1 & B2 & B3>
 * 如果B1是Class必须首先指定它
 * @param <T>
 */
public class NaturalNumber<T extends Integer> {

    private T n;

    public NaturalNumber(T n) {
        this.n = n;
    }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }

    // ...
}