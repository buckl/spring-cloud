package com.lft.java.language.features.generic;

public class WrapperTest {

    public void test() {
        Wrapper<String> wrapper = new Wrapper<>("Hello");
        wrapper.set("set a string");
        Wrapper<Object> objectWrapper = new Wrapper<>(new Object());
        objectWrapper.set(new Object());
        objectWrapper.set("set a string");
//        wrapper  = objectWrapper;如果这个被允许，那么下面这个就会返回String，
//        但是objectWrapper中存储的是Object，Object要转为String就会有类型转换异常
//        String s = wrapper.get();
        Wrapper wrapper1 = new Wrapper<>("Hello");
        wrapper1 = wrapper;
    }
}
