package com.felixwc.springboot.redis.key.service.impl;

import com.felixwc.springboot.redis.key.KeyApp;
import com.felixwc.springboot.redis.key.service.KeyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;


@SpringBootTest(classes = {KeyApp.class})
public class KeyServiceImplTest {

    @Autowired
    private KeyService service;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void deleteKey() {
        redisTemplate.opsForValue().set("name","zhangsan");
        boolean b = service.deleteKey("name");
        Assertions.assertEquals(b,true);
    }
}