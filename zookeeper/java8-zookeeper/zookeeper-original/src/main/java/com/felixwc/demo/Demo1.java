package com.felixwc.demo;

import com.felixwc.utils.ZkClient;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * in order to learn java!
 * created at 2022/4/24 14:26
 *
 * @author felixwc
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException, KeeperException {
        ZooKeeper client = ZkClient.getClient();
        List<String> children = client.getChildren("/", false);
        children.stream().forEach(System.out::println);
    }
}
