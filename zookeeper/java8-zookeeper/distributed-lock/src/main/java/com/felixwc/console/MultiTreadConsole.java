package com.felixwc.console;

/**
 * in order to learn java!
 * created at 2022/4/25 12:12
 *
 * @author felixwc
 */
public class MultiTreadConsole {
    private int threadCount;

    public MultiTreadConsole(int threadCount) {
        this.threadCount = threadCount;
    }

    public void start(Runnable runnable){
        for(int i=0;i<threadCount;i++){
            Thread thread = new Thread(runnable, "MultiTreadConsole Thread" + i);
            thread.start();
        }
    }
}
