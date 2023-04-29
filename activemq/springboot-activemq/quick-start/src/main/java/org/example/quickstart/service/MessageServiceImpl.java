package org.example.quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/1/23--@19:08
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Override
    public void sendMessage(String message) {
        System.out.println("等待发送的信息为：" + message);
        jmsMessagingTemplate.setDefaultDestinationName("hello");
        jmsMessagingTemplate.convertAndSend(message);
    }

    @Override
    public String doMessage() {
        jmsMessagingTemplate.setDefaultDestinationName("hello");
        String message = jmsMessagingTemplate.receiveAndConvert(String.class);
        System.out.println("已经接收到信息：" + message);
        return message;
    }
}
