package com.felixwc.rabbit;

import com.felixwc.rabbit.directqueue.Consumer;
import com.felixwc.rabbit.directqueue.Producer;
import com.felixwc.rabbit.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * in order to learn java!
 * created at 2022/8/5 07:19
 *
 * @author felixwc
 */
public class RabbitMQApp {
    public static void main(String[] args) throws IOException {
        Producer producer = new Producer();
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                try {
                    int j=0;
                    while (j<10000){
                        producer.sentMessage(RabbitMQUtils.obtainChannel());
                        Thread.sleep(100);
                        j++;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        Consumer consumer = new Consumer();
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                Channel channel = RabbitMQUtils.obtainChannel();
                try {
                    consumer.consumer(channel);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
