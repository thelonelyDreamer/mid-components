package com.felixwc.java8.rabbitmq.hello.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * in order to learn java!
 * created at 2022/3/31 02:41
 *
 * @author wangchao
 */
public class RabbitMqUtils {
    private static volatile Connection conn;

    public static ConnectionFactory getConnectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("root");
        factory.setHost("42.192.49.180");
        factory.setPort(5672);
        return  factory;
    }

    public static Channel getChannel() throws IOException, TimeoutException {
        if(conn==null){
            synchronized (RabbitMqUtils.class){
                conn = getConnectionFactory().newConnection();
            }
        }
        return conn.createChannel();
    }


}
