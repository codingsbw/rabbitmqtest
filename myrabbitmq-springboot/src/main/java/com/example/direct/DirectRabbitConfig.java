package com.example.direct;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Steven Shi
 * @date 2019/7/20 14:06
 */
@Configuration
public class DirectRabbitConfig {
    private static String message = "q_direct_message";
    private static String messages = "q_direct_messages";

    @Bean
    public Queue queueDirectMessage() {
        return new Queue(DirectRabbitConfig.message);
    }

    @Bean
    public Queue queueDirectMessages() {
        return new Queue(DirectRabbitConfig.messages);
    }

    // 声明一个direct类型的交换机
    @Bean
    DirectExchange exchangeDirect() {
        return new DirectExchange("mybootdirectexchange");
    }

    // 绑定Queue到交换机，并且指定routingkey
    @Bean
    Binding bindingDirectExchangeMessage(Queue queueDirectMessage, DirectExchange exchangeDirect) {
        return BindingBuilder.bind(queueDirectMessage).to(exchangeDirect).with("insert");
    }

    @Bean
    Binding bindingDirectExchangeMessages(Queue queueDirectMessages, DirectExchange exchangeDirect) {
        return BindingBuilder.bind(queueDirectMessages).to(exchangeDirect).with("update");
    }
}
