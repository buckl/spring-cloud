package com.lft.java.language.features.generic;

/**
 * T to indicate that
 * the parameter is a type, E to indicate that the parameter is an element, K to indicate that the parameter is a
 * key, N to indicate the parameter is a number, and V to indicate that the parameter is a value
 *
 * @param <T>
 */

public class Wrapper<T> {
    private T ref;

    public Wrapper(T ref) {
        this.ref = ref;
    }

    public T get() {
        return ref;
    }

    public void set(T ref) {
        this.ref = ref;
    }
}