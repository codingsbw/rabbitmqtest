package com.example.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Steven Shi
 * @date 2019/7/20 14:49
 */
@Component
public class MsgSenderFanout {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("mybootfanoutExchange", "", context);
    }
}
