package com.felixwc.rabbit.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * in order to learn java!
 * created at 2022/8/5 07:24
 *
 * @author felixwc
 */
public class RabbitMQUtils {
    private static ConnectionFactory factory = null;
    private static Connection connection = null;
    private static ThreadLocal<Channel> channelThreadLocal = new ThreadLocal<>();

    static {
        factory = new ConnectionFactory();
        configClient();
    }

    public static Channel obtainChannel() {
        Channel channel = channelThreadLocal.get();
        if (null == channel) {
            if (null == connection) {
                synchronized (RabbitMQUtils.class) {
                    if (null == connection) {
                        configClient();
                    }
                }
            }
            try {
                channel = connection.createChannel();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return channel;
    }

    public static void closeChannel() {
        Channel channel = channelThreadLocal.get();
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
            channelThreadLocal.remove();
        }
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void configClient() {
        try {
            factory.setHost("42.192.49.180");
            factory.setPort(5672);
            factory.setUsername("root");
            factory.setPassword("root");
            connection = factory.newConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
