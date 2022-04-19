package com.felixwc.java8.rabbitmq.hello.demo2;

import com.felixwc.java8.rabbitmq.hello.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/**
 * in order to learn java!
 * created at 2022/3/31 14:59
 *
 * @author wangchao
 */
public class Demo2Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(Demo2Properties.getQueueName(),false,false,false,null);
        String str = Demo2Properties.class.getName()+"发送消息";
        for (int i = 0; i <100 ; i++) {
            channel.basicPublish("",Demo2Properties.getQueueName(),null,(str+i).getBytes(Charset.forName("utf-8")));
        }
        channel.close();
    }
}
