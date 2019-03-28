package com.study.concurrency.concurrencydemo;

/**
 * @program: concurrencydemo
 * @description: 多线程不安全
 * @author: zf
 * @create: 2019-03-28 11:47
 **/
public class ThreadsTest implements Runnable {
    private int tickets = 1;

    @Override
    public void run() {
        while (tickets <= 50) {
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖了第" + tickets + "张票");
                    tickets++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadsTest tt = new ThreadsTest();
        Thread th1 = new Thread(tt, "1号窗口");
        Thread th2 = new Thread(tt, "2号窗口");
        th1.start();
        th2.start();
    }
}