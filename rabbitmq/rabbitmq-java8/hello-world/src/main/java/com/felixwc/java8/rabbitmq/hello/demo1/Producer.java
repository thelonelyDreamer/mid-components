package com.felixwc.java8.rabbitmq.hello.demo1;

import com.felixwc.java8.rabbitmq.hello.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * in order to learn java!
 * created at 2022/3/31 02:39
 *
 * @author wangchao
 */
public class Producer {
    private  String queueName;

    public Producer(String queueName) {
        this.queueName = queueName;
    }

    public boolean send(String msg) throws IOException {
        try {
            ConnectionFactory factory = RabbitMqUtils.getConnectionFactory();
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(queueName,false,false,false,null);
            while (msg!=null) {
                channel.basicPublish("",queueName, null, msg.getBytes());
                Thread.sleep(1000);
            }
            channel.close();
            connection.close();
        } catch (TimeoutException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
