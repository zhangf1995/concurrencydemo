package com.study.concurrency.concurrencydemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: concurrencydemo
 * @description: atmoic引用类型
 * @author: zf
 * @create: 2019-03-28 15:30
 **/
public class AtmoicYinYongClass {
    public static void main(String[] args) {
        AtomicReference<User> reference = new AtomicReference<>();
        User user1 = new User("zs", 10);
        System.out.println(user1);
        User reUser = reference.getAndSet(user1);
        System.out.println(reUser);
        User user2 = new User("ls", 20);
        User referenceAndSet = reference.getAndSet(user2);
        System.out.println(referenceAndSet);
        boolean b = reference.compareAndSet(user2, user1);
        System.out.println(b);
        System.out.println(reference.get());
    }

    static class User{
        private String username;
        private Integer age;

        public User(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{username:"+username+",age:"+age+"}";
        }
    }
}
