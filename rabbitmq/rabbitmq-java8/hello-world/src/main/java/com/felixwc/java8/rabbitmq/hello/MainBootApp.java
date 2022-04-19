package com.felixwc.java8.rabbitmq.hello;

import com.felixwc.java8.rabbitmq.hello.demo1.Producer;

import java.io.IOException;

/**
 * in order to learn java!
 * created at 2022/3/31 02:37
 *
 * @author wangchao
 */
public class MainBootApp {
    public static void main(String[] args) {
        try {
            new Producer("hello").send("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
