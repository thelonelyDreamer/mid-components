package org.example.component;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/2/5--@21:26
 */
@Configuration
public class KafkaConsumer {
    private static Integer int1=0;
    private static Integer int2=0;
    @KafkaListener(topics = {"test"})
    public void consume(String message) {
        if(Objects.nonNull(message)) System.out.println("consumer1"+(++int1));
    }

    @KafkaListener(topics = {"test"},groupId = "tstest1")
    public void consume2(String message){
        if(Objects.nonNull(message)) System.out.println(++int2);
    }
}
