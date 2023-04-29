package org.example.quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageServiceImplTest {
    @Autowired
    private MessageService service;
    @org.junit.jupiter.api.Test
    void sendMessage() {
        service.sendMessage("hello message");
    }

    @org.junit.jupiter.api.Test
    void doMessage() {
        service.doMessage();
    }
}