package com.felixwc.springboot.redis.key.service;

/**
 * in order to learn java!
 * created at 2022/3/14 16:03
 *
 * @author wangchao
 */
public interface KeyService {
    boolean deleteKey(String key);
    Long deleteKeys(String... keys);

}
