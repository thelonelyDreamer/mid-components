package com.felixwc.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.client.ZKClientConfig;

/**
 * in order to learn java!
 * created at 2022/4/24 23:25
 *
 * @author felixwc
 */
public class CuratorClientUtils {
    private static String addr = "42.192.49.180:2181";

    public static CuratorFramework getClient1() {
        /*
         * @param connectString       list of servers to connect to
         * @param sessionTimeoutMs    session timeout
         * @param connectionTimeoutMs connection timeout
         * @param retryPolicy         retry policy to use
         * @param zkClientConfig      ZKClientConfig
         */
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                addr, 3000, 1000,
                new RetryForever(100), new ZKClientConfig());
        client.start();
        return client;
    }

    public static CuratorFramework getClient2() {
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
