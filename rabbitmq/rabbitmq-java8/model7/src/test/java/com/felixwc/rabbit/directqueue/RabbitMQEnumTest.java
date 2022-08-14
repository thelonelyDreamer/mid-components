package com.felixwc.rabbit.directqueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class RabbitMQEnumTest {

    @Test
    public  void test(){
        String name = RabbitMQEnum.DIRECT_QUEUE.name();
        System.out.println(name);
    }
}