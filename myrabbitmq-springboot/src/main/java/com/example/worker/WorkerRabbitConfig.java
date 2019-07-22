package com.example.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Steven Shi
 * @date 2019/7/20 11:30
 */
@Configuration
public class WorkerRabbitConfig {
    @Bean
    public Queue queueWorker() {
        return new Queue("q_hello");
    }
}
