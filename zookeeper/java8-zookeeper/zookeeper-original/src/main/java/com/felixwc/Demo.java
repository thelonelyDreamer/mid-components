package com.felixwc;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * in order to learn java!
 * created at 2022/4/24 12:04
 *
 * @author felixwc
 */
public class Demo {
    private static String ip = "42.192.49.180:2181";
    private static int session_timeout = 40000;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(ip, session_timeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    //确认已经连接完毕后再进行操作
                    latch.countDown();
                    System.out.println("已经获得了连接");
                }
            }
        });

        //连接完成之前先等待
        latch.await();
        ZooKeeper.States states = zooKeeper.getState();
        System.out.println(states);
    }
}
