package com.lft.java.language.features.generic;

import com.lft.java.language.features.entity.Employee;
import com.lft.java.language.features.entity.Manager;

public class WrapperUtil {
    public static void printDetails(Wrapper<Object> wrapper) {
        // More code goes here
    }

    public static double sum(Wrapper<? extends Number> n1, Wrapper<? extends Number> n2) {
        Number num1 = n1.get();
        Number num2 = n2.get();
        double sum = num1.doubleValue() + num2.doubleValue();
        return sum;
    }

    public void test1() {
        Wrapper<Integer> intWrapper = new Wrapper<>(new Integer(10));
        Wrapper<? extends Number> numberWrapper = intWrapper; // OK
        Wrapper<? extends Number> numberWrapper1 = new Wrapper<>(new Double(12.0));
        Wrapper<Integer> intWrapper1 = (Wrapper<Integer>) numberWrapper1;
//        numberWrapper.set(new Integer(1220)); // A compile-time error
//        numberWrapper.set(new Double(12.20)); // A compile-time error
    }

    public void test2() {
        Wrapper<? extends Employee> wrapper = new Wrapper<>(new Manager());
//        wrapper.set(new Employee()); A compile-time error

    }

    public void testCopy1() {
        Wrapper<String> stringWrapper = new Wrapper<String>("Hello");
        Wrapper<Object> objectWrapper = new Wrapper<Object>(new Object());
//        WrapperUtil.copy1(stringWrapper, objectWrapper); // A compile-time error copy1 中类型参数T,必须一致
    }
    public static <T> void copy1(Wrapper<T> source, Wrapper<T> dest) {
        T value = source.get();
        dest.set(value);
    }

    public void testCopy2() {
        Wrapper<String> stringWrapper = new Wrapper<>("Hello");
        Wrapper<Object> objectWrapper = new Wrapper<>(new Object());
        WrapperUtil.copy2(stringWrapper, objectWrapper);
    }

    public static <T> void copy2(Wrapper<T> source, Wrapper<? super T> dest) {
        T value = source.get();
        dest.set(value);
    }

    public void test() {
        Wrapper<Object> objectWrapper = new Wrapper<Object>(new Object());
        WrapperUtil.printDetails(objectWrapper); // OK
        Wrapper<String> stringWrapper = new Wrapper<String>("Hello");
//        WrapperUtil.printDetails(stringWrapper); // A compile-time error
        Wrapper<?> wrapper1 = new Wrapper<>("string");
        Object o = wrapper1.get();
    }
}