package com.felixwc.rabbit.utils;

import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * in order to learn java!
 * created at 2022/8/7 07:35
 *
 * @author felixwc
 */
public class DeliverCallbackImpl implements DeliverCallback {

    @Override
    public void handle(String consumerTag, Delivery message) throws IOException {
        System.out.println(new String(message.getBody(),"UTF-8"));
        System.out.println("consumer Tag:"+consumerTag);
    }
}
