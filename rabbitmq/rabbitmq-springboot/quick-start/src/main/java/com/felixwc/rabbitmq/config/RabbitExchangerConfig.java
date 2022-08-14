package com.felixwc.rabbitmq.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * in order to learn java!
 * created at 2022/8/6 22:33
 *
 * @author felixwc
 */
@Configuration
public class RabbitExchangerConfig {
    private  static  final  String DIRECT_EXCHANGER = "direct-exchanger";
    private static final String DEAD_EXCHANGER="dead-exchanger";

    private static final String TEN_SECOND_QUEUE="ten-second-queue";
    private static final String TWENTY_SECOND_QUEUE="twenty-second-queue";

    @Bean("directExchanger")
    public DirectExchange directExchanger(){
        return  new DirectExchange(DIRECT_EXCHANGER);
    }
    @Bean("deadExchanger")
    public DirectExchange deadExchanger(){
        return  new DirectExchange(DEAD_EXCHANGER);
    }
}
