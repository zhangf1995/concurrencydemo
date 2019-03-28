package com.study.concurrency.concurrencydemo;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: concurrencydemo
 * @description: atomic的一些类
 * @author: zf
 * @create: 2019-03-28 14:31
 **/
public class AtomicClass {
    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "bbb";
        //AtomicStampedReference  解决cas的aba问题
        AtomicStampedReference<String> reference = new AtomicStampedReference<>(str1, 0);
        boolean b = reference.compareAndSet(str1, str2, reference.getStamp(), reference.getStamp() + 1);
        System.out.println(b);
        System.out.println(reference.getReference());
        System.out.println(reference.getStamp());
        boolean c = reference.compareAndSet(str2, "aaa", reference.getStamp(), reference.getStamp() + 1);
        System.out.println(c);
        System.out.println(reference.getReference());
        System.out.println(reference.getStamp());
        boolean d = reference.compareAndSet("aaa", str2, 0, reference.getStamp() + 1);
        System.out.println(d);
        System.out.println(reference.getReference());
        System.out.println(reference.getStamp());
    }
}
