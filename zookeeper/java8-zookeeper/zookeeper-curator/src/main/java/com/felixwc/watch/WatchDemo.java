package com.felixwc.watch;

import com.felixwc.utils.CuratorClientUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreV2;

/**
 * in order to learn java!
 * created at 2022/4/25 00:25
 *
 * @author felixwc
 */
public class WatchDemo {
    private static CuratorFramework client = CuratorClientUtils.getClient2();
    public static void test(CuratorFramework client) throws Exception {
        NodeCache nodeCache = new NodeCache(client,"/zookeeper");
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("test");
            }
        });
        nodeCache.start();
    }

    public static void test2(){
        client.getCuratorListenable().addListener(new CuratorListener() {
            @Override
            public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("test");
            }
        });
    }
    public static void main(String[] args) throws Exception {
        InterProcessMutex interProcessMutex = new InterProcessMutex(client, "/lock");
        interProcessMutex.acquire();
        System.out.println("成功获取锁");
        Thread.sleep(100000);
        interProcessMutex.release();
    }
}
