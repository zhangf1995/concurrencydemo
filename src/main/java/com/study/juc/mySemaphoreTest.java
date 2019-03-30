package com.study.juc;

import java.util.concurrent.*;

/**
 * @program: concurrencydemo
 * @description: 信号量Semaphore
 * @author: zf
 * @create: 2019-03-30 14:38
 **/
public class mySemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int a=0;a<100;a++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(semaphore.tryAcquire(1000,TimeUnit.MILLISECONDS)){
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);semaphore.release();
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
