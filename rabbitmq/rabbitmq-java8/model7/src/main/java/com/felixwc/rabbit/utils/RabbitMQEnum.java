package com.felixwc.rabbit.utils;

/**
 * in order to learn java!
 * created at 2022/8/7 08:32
 *
 * @author felixwc
 */
public enum RabbitMQEnum {
    DEAD_QUEUE("dead-queue");
    private String value;

    RabbitMQEnum(String value) {
        this.value = value;
    }
}
