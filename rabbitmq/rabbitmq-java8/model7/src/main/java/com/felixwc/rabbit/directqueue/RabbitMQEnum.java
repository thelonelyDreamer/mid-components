package com.felixwc.rabbit.directqueue;

/**
 * in order to learn java!
 * created at 2022/8/7 09:01
 *
 * @author felixwc
 */
public enum RabbitMQEnum {
    DIRECT_QUEUE("direct-queue");

    private String value;

    RabbitMQEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
