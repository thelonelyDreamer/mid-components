package com.felixwc.springboot.redis.hello.sevice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ZSetServiceTest {
    @Autowired
    ZSetService service;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    private static final String SET_NAME = "my-zset";

    @BeforeEach
    void beforeEach(){
        redisTemplate.delete(SET_NAME);
    }

    @Test
    void addStringScore() {
        boolean b = service.addStringScore(SET_NAME, "shine", 1.85);
        Assertions.assertEquals(b, true);
        b =  service.addStringScore(SET_NAME, "shine", 1.75);
        Assertions.assertEquals(b, false);
    }

    @Test
    void zCard() {
        long myZSet = service.zCard(SET_NAME);
        Assertions.assertEquals(myZSet, 0);
        redisTemplate.opsForZSet().add(SET_NAME,"shine",1.85);
        myZSet = service.zCard(SET_NAME);
        Assertions.assertEquals(myZSet, 1);
    }
}