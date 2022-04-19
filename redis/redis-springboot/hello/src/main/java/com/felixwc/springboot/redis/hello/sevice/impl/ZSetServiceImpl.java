package com.felixwc.springboot.redis.hello.sevice.impl;

import com.felixwc.springboot.redis.hello.sevice.ZSetService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

/**
 * in order to learn java!
 * created at 2022/3/14 12:26
 *
 * @author wangchao
 */
@Service
public class ZSetServiceImpl implements ZSetService {
    private final  ZSetOperations<String, String> zSetOperations;
    public ZSetServiceImpl(RedisTemplate<String, String> redisTemplate) {
        zSetOperations = redisTemplate.opsForZSet();
    }


    @Override
    public boolean addStringScore(String key, String value, double score) {
        Boolean result = zSetOperations.add(key, value, score);
        return result;
    }

    @Override
    public long zCard(String key) {
        Long zCard = zSetOperations.zCard(key);
        return zCard.longValue();
    }

}
