package com.felixwc.rabbit;

import com.felixwc.rabbit.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;

/**
 * in order to learn java!
 * created at 2022/8/5 07:19
 *
 * @author felixwc
 */
public class RabbitMQApp {
    public static void main(String[] args) {
        Channel channel = RabbitMQUtils.obtainChannel();
        
    }
}
