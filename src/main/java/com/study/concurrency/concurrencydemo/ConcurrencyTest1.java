package com.study.concurrency.concurrencydemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: concurrencydemo
 * @description: test2
 * @author: zf
 * @create: 2019-03-27 16:31
 **/
public class ConcurrencyTest1 {
    public static void main(String[] args) {
        test1();
        //test2();
    }

    private static void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int a = 0; a < 100; a++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
    }

    private static void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int a = 0; a < 20; a++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
    }
}
