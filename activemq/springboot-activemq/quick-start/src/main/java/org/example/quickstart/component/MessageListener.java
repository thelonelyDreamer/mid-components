package org.example.quickstart.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/1/23--@19:11
 */
@Component
public class MessageListener {
    @JmsListener(destination = "order.queue.message")
    private void receive(String message){
        System.out.println("自动接收到消息："+ message);
    }
}
