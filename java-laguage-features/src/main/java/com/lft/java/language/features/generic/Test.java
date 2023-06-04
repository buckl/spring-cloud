package com.lft.java.language.features.generic;

public class Test<T> {
    public <V> void m1(Wrapper<V> a, Wrapper<V> b, T c) {
        // Do something
    }

    public void test(){
        Test<String> test  = new Test<>();
        Wrapper<Integer> iw1 = new Wrapper<>(201);
        Wrapper<Integer> iw2 = new Wrapper<>(202);
        test.m1(iw1,iw2,"hello");


    }

}