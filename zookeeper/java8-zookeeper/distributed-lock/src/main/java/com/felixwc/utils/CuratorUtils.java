package com.felixwc.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;

/**
 * in order to learn java!
 * created at 2022/4/25 11:23
 *
 * @author felixwc
 */
public class CuratorUtils {
    private static String addr = "42.192.49.180:2181";
    public static CuratorFramework getClient(){
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(addr)
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(new RetryForever(100))
                .namespace("test2")
                .build();
        client.start();
        return client;
    }
}
