package com.felixwc.crud;

import com.felixwc.utils.CuratorClientUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * in order to learn java!
 * created at 2022/4/25 00:05
 *
 * @author felixwc
 */
public class ReadDemo {
    private static CuratorFramework client = CuratorClientUtils.getClient2();

    public void test1(){
        try {
            byte[] bytes = client.getData().forPath("/test1");
            System.out.println(new String(bytes));
            List<String> strings = client.getChildren().forPath("/");
            Stat stat = new Stat();
            client.getData().storingStatIn(stat).forPath("/");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
