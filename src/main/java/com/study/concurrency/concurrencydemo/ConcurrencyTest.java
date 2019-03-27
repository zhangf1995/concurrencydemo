package com.study.concurrency.concurrencydemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @program: concurrencydemo
 * @description: 并发测试CountDownLatch类
 * @author: zf
 * @create: 2019-03-22 09:58
 **/

public class ConcurrencyTest {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        for (int a = 0; a < 5; a++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        System.out.println(Thread.currentThread().getName() + "开始起跑");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"到达终点");
                        end.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            System.out.println("还有一秒钟开始比赛");
            Thread.sleep(1000);
            System.out.println("比赛开始");
            begin.countDown();
            end.await();
            System.out.println("比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
