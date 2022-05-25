package com.felixwc.locks.demo1;

import com.felixwc.methods.Methods1Demo;
import com.felixwc.utils.CuratorUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * in order to learn java!
 * created at 2022/4/25 11:31
 *
 * @author felixwc
 */
public class executor {
    private  static CuratorFramework client = CuratorUtils.getClient();
    public static void test(){
        try {
            InterProcessLock lock = getLock(InterProcessMutex.class);
            System.out.println(lock);
            methods.test1(lock);
            methods.test2(lock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class methods{
        public static void test1(InterProcessLock lock) throws Exception {
            lock.acquire();
            Methods1Demo.test1();
            lock.release();
        }

        public static void test2(InterProcessLock lock) throws Exception {
            lock.acquire();
            Methods1Demo.test3();
            lock.release();
        }
    }

    private static InterProcessLock getLock(Class c){
        InterProcessLock lock =null;
        if(c.isAssignableFrom(InterProcessMutex.class)){
            lock = new InterProcessMutex(client,"/lock");
        }else{
            lock = null;
        }

        return lock;
    }
}
