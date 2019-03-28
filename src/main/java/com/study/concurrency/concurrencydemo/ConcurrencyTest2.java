package com.study.concurrency.concurrencydemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: concurrencydemo
 * @description: AtomicInteger类
 * @author: zf
 * @create: 2019-03-27 17:22
 **/
public class ConcurrencyTest2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        CountDownLatch countDownLatch1 = new CountDownLatch(1000);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int a=0;a<1000;a++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for(int b=0;b<1000;b++){
                        atomicInteger.getAndIncrement();
                    }
                    countDownLatch1.countDown();
                }
            });
            countDownLatch.countDown();
        }
        try {
            countDownLatch1.await();
            System.out.println(atomicInteger);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
