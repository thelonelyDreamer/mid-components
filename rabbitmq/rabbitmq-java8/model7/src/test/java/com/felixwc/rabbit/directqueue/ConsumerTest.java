package com.felixwc.rabbit.directqueue;

import com.felixwc.rabbit.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class ConsumerTest {
    @Test
    public void client() throws IOException, InterruptedException {
        final int core = 4;
        Consumer consumer = new Consumer();
        Channel channel = RabbitMQUtils.obtainChannel();
        channel.queueDeclare(RabbitMQEnum.DIRECT_QUEUE.getValue(), false,
                false,true,null);
        consumer.consumer(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}