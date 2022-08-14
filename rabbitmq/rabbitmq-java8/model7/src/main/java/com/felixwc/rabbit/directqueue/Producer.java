package com.felixwc.rabbit.directqueue;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * in order to learn java!
 * created at 2022/8/7 08:59
 *
 * @author felixwc
 */
public class Producer {

    public void sentMessage(Channel channel) throws IOException {
        String name = RabbitMQEnum.DIRECT_QUEUE.getValue();
        channel.queueDeclare(name,false,false,true,null);
        String message = obtainMessage();
        channel.basicPublish("",name,null,message.getBytes(StandardCharsets.UTF_8));
//        RabbitMQUtils.closeChannel();
    }

    private String obtainMessage() {
        return "Hello Word!";
    }
}
