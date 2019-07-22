package com.example.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Steven Shi
 * @date 2019/7/20 14:31
 */
@Component
@RabbitListener(queues = "q_topic_message")
public class Receiver1 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Received1: " + hello);
    }
}
