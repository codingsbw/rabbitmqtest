package com.example.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Steven Shi
 * @date 2019/7/20 14:27
 */
@Component
public class MsgSenderDirect {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender: " + context);
        rabbitTemplate.convertAndSend("mybootdirectexchange", "insert", context);
    }

    public void send2() {
        String context = "hi, i am message 2";
        System.out.println("Sender: " + context);
        rabbitTemplate.convertAndSend("mybootdirectexchange", "update", context);
    }
}
