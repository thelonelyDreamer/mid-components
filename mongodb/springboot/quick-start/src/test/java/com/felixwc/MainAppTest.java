package com.felixwc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainAppTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void main() {
        mongoTemplate.createCollection("", CollectionOptions.empty());
    }
}