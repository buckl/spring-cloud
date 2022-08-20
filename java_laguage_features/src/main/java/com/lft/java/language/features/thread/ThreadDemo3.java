package com.lft.java.language.features.thread;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int count = 0;
                while (!Thread.interrupted()) {
                    System.out.println(name + ": " + count++);
                }
            }
        };
        Thread thdA = new Thread(r);
        Thread thdB = new Thread(r);
        thdA.start();
        thdB.start();
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ie)
        {
        }
        System.out.println("sleep 2s");
        thdA.interrupt();
        thdB.interrupt();
    }

}
