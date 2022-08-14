package com.felixwc.rabbit.directqueue;

import com.felixwc.rabbit.utils.CancelCallbackImpl;
import com.felixwc.rabbit.utils.DeliverCallbackImpl;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * in order to learn java!
 * created at 2022/8/7 08:59
 *
 * @author felixwc
 */
public class Consumer {
    public void consumer(Channel channel) throws IOException {
        channel.basicConsume(RabbitMQEnum.DIRECT_QUEUE.getValue(),true,
                new DeliverCallbackImpl(),new  CancelCallbackImpl());
    }
}
