package com.felixwc.springboot.redis.hello.sevice;

/**
 * in order to learn java!
 * created at 2022/3/14 12:26
 *
 * @author wangchao
 */
public interface ZSetService {
    /**
     * 创建一个有序集合
     * @param key 略
     * @param value 略
     * @param score 略
     * @return 返回是否插入成功
     */
    boolean addStringScore(String key,String value,double score);

    /**
     * 返回有序集合的个数，不存在返回0
     * @param key
     * @return
     */
    long zCard(String key);
}
