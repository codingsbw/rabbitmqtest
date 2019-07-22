package com.example.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Steven Shi
 * @date 2019/7/20 14:06
 */
@Configuration
public class TopicRabbitConfig {
    private static String message = "q_topic_message";
    private static String messages = "q_topic_messages";

    @Bean
    public Queue queueTopicMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueTopicMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    // 声明一个Topic类型的交换机
    @Bean
    TopicExchange exchangeTopic() {
        return new TopicExchange("myboottopicexchange");
    }

    // 绑定Queue到交换机，并且指定routingkey
    @Bean
    Binding bindingTopicExchangeMessage(Queue queueTopicMessage, TopicExchange exchangeTopic) {
        return BindingBuilder.bind(queueTopicMessage).to(exchangeTopic).with("topic.message");
    }

    @Bean
    Binding bindingTopicExchangeMessages(Queue queueTopicMessages, TopicExchange exchangeTopic) {
        return BindingBuilder.bind(queueTopicMessages).to(exchangeTopic).with("topic.#");
    }
}
