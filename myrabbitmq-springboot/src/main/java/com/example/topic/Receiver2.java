package com.example.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Steven Shi
 * @date 2019/7/20 14:32
 */
@Component
@RabbitListener(queues = "q_topic_messages")
public class Receiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Reveiver2: " + hello);
    }
}
