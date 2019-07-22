package com.example.simple;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消息生产者
 *
 * @author Steven Shi
 * @date 2019/7/20 11:32
 */
@Component
public class SimpleHelloSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "hello " + date;
        System.out.println("Sender: " + context);
        // 简单队列的情况下routingkey即为Queue名
        rabbitTemplate.convertAndSend("q_hello", context);
    }
}
