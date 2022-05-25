package com.felixwc.crud;

import com.felixwc.utils.CuratorClientUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.StandardCharsets;

/**
 * in order to learn java!
 * created at 2022/4/24 23:58
 *
 * @author felixwc
 */
public class CreateDemo {
    private static CuratorFramework client = CuratorClientUtils.getClient2();

    public void test1(){
        try {
            client.create().forPath("/test1");
            client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/","".getBytes(StandardCharsets.UTF_8));
            client.create().forPath("/test1","test".getBytes(StandardCharsets.UTF_8));
            client.create().creatingParentsIfNeeded().forPath("/test");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
