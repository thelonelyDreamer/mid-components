package com.felixwc.springboot.redis.key.temp;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * in order to learn java!
 * created at 2022/3/14 15:40
 *
 * @author wangchao
 */
@Service
public class MyService {
    private final StringRedisTemplate template;
    public MyService(StringRedisTemplate template) {
        this.template = template;
    }

    public void test1(){

    }
}
