package com.felixwc.springboot.redis.key.service.impl;

import com.felixwc.springboot.redis.key.service.KeyService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * in order to learn java!
 * created at 2022/3/14 16:07
 *
 * @author wangchao
 */
@Service
public class KeyServiceImpl implements KeyService {

    private StringRedisTemplate redisTemplate;

    public KeyServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long deleteKeys(String... keys) {
        return redisTemplate.delete(Arrays.asList(keys));
    }
}
