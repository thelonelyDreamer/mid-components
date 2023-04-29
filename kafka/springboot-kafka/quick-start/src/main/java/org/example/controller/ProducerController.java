package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/2/6--@0:35
 */
@RequestMapping("/producer")
@RestController
public class ProducerController {
    @Autowired
    KafkaTemplate<String,String> template;

    @RequestMapping("/send")
    public void send(){
        for (int i = 0; i <10000; i++) {
            template.send("test", UUID.randomUUID().toString());
        }
    }
}
