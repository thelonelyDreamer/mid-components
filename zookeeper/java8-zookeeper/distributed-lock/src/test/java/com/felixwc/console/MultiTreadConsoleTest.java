package com.felixwc.console;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiTreadConsoleTest {
    private AtomicInteger i= new AtomicInteger(0);

    @Test
    public void start() throws InterruptedException {
        MultiTreadConsole multiTreadConsole = new MultiTreadConsole(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        multiTreadConsole.start(()->{
            i.addAndGet(10);
            countDownLatch.countDown();
        });
        countDownLatch.await();
        System.out.println(i.get());
    }
}