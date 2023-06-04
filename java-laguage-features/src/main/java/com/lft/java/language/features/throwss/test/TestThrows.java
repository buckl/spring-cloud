package com.lft.java.language.features.throwss.test;

public class TestThrows {

    public void test() throws Exception {
        System.out.println(1);
    }

    public static void main(String[] args) throws Exception {
        TestThrows testThrows = new TestThrows();
        testThrows.test();
        Thread myThread = new Thread(ThreadTest::execute);
        myThread.start();
    }
}

class ThreadTest {
    public static void execute() {
        System.out.println("Hello Java threads!");
    }
}