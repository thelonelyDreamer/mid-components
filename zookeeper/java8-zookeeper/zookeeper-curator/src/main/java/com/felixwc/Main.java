package com.felixwc;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;

public class Main {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("42.192.49.180:2181", new RetryForever(100));
        curatorFramework.delete().withVersion(-1).forPath("/wangchao");
        System.out.println("Hello world!");
    }
}