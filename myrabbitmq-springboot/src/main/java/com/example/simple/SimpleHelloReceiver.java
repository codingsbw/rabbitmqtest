package com.example.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 *
 * @author Steven Shi
 * @date 2019/7/20 11:35
 */
@Component
@RabbitListener(queues = "q_hello")
public class SimpleHelloReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver: " + hello);
    }
}
