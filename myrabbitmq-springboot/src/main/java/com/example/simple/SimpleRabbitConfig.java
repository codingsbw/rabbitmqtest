package com.example.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Steven Shi
 * @date 2019/7/20 11:30
 */
@Configuration
public class SimpleRabbitConfig {
    @Bean
    public Queue queueSimple() {
        return new Queue("q_hello");
    }
}
