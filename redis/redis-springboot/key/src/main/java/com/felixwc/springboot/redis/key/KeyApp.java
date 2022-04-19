package com.felixwc.springboot.redis.key;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * in order to learn java!
 * created at 2022/3/14 15:22
 *
 * @author wangchao
 */
@SpringBootApplication
@EnableSwagger2WebMvc
public class KeyApp {
    public static void main(String[] args) {
        SpringApplication.run(KeyApp.class,args);
    }
}
