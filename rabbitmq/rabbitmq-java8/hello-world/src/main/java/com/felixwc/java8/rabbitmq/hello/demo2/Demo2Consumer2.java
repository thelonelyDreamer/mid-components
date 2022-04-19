package com.felixwc.java8.rabbitmq.hello.demo2;

import com.felixwc.java8.rabbitmq.hello.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * in order to learn java!
 * created at 2022/3/31 15:13
 *
 * @author wangchao
 */
public class Demo2Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [consumer2] Received '" + message + "'");
        };
        channel.basicConsume(Demo2Properties.getQueueName(), true, deliverCallback, consumerTag -> { });
    }
}
