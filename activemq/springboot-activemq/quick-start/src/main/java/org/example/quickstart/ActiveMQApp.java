package org.example.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class ActiveMQApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ActiveMQApp.class, args);
        ConnectionFactory bean = context.getBean(ConnectionFactory.class);
        System.out.println(bean);
    }
}
