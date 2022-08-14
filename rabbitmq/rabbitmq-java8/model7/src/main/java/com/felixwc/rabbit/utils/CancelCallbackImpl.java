package com.felixwc.rabbit.utils;

import com.rabbitmq.client.CancelCallback;

import java.io.IOException;

/**
 * in order to learn java!
 * created at 2022/8/7 09:40
 *
 * @author felixwc
 */
public class CancelCallbackImpl implements CancelCallback {
    @Override
    public void handle(String consumerTag) throws IOException {
        System.out.println("consumerTag:"+consumerTag);
    }
}
