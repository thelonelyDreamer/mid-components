package com.felixwc.methods;

/**
 * in order to learn java!
 * created at 2022/4/25 11:12
 * 提供方法
 * @author felixwc
 */
public class Methods1Demo {

    public static void test1(){
        try {
            System.out.println("test1 in Methods1Demo threadName="+Thread.currentThread().getName());
            Thread.sleep(1000);
            test2();
            Thread.sleep(3000);
            System.out.println("test1 in Methods1Demo end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test2() throws InterruptedException {
        System.out.println("test2 in Methods1Demo threadName="+Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println("test2 in Methods1Demo threadName="+Thread.currentThread().getName());
    }

    public  static void test3() throws InterruptedException {
        System.out.println("test3 in Methods1Demo threadName="+Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println("test3 in Methods1Demo threadName="+Thread.currentThread().getName());
    }
}
