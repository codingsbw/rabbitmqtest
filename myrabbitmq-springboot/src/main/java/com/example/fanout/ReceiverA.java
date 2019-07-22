package com.example.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Steven Shi
 * @date 2019/7/20 14:47
 */
@Component
@RabbitListener(queues = "q_fanout_A")
public class ReceiverA {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("AReceiver: " + hello);
    }
}
