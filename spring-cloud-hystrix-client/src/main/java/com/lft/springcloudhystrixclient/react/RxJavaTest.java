package com.lft.springcloudhystrixclient.react;

import rx.Observer;
import rx.Scheduler;
import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Random;

public class RxJavaTest {
    private final static Random random = new Random();

    public static void main(String[] args) {
        int i = random.nextInt(200);
//        just 数据源 Schedulers订阅的线程池immediate当前线程，subscribe回调方法
        Single.just("hello world").subscribeOn(Schedulers.immediate()).subscribe(new Observer<String>() {
            //        正常流程
            @Override
            public void onCompleted() {
                System.out.println("success");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.print("熔断保护");
            }

            @Override
            public void onNext(String s) {

                System.out.print("helloWorld sleep " + i + " 秒 \n");
                if (i > 100) {
                    throw new RuntimeException("timeout!");
                }
            }
        });
    }
}
