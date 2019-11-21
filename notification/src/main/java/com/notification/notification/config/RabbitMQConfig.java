package com.notification.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("${notification.queue1}")
    String queue1;

    @Value("${notification.queue2}")
    String queue2;

    @Value("${notification.queue3}")
    String queue3;

    @Value("${notification.exchange}")
    String exchange;

    @Value("${notification.routingkey1}")
    private String routingkey1;

    @Value("${notification.routingkey2}")
    private String routingkey2;

    @Value("${notification.routingkey3}")
    private String routingkey3;

    @Bean
    Queue queue1() {
        return new Queue(queue1, true);
    }

    @Bean
    Queue queue2() {
        return new Queue(queue2, true);
    }

    @Bean
    Queue queue3() {
        return new Queue(queue3, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    Binding bindingQueue1(Queue queue1, TopicExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with(routingkey1);
    }

    @Bean
    Binding bindingQueue2(Queue queue2, TopicExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with(routingkey2);
    }

    @Bean
    Binding bindingQueue3(Queue queue3, TopicExchange exchange) {
        return BindingBuilder.bind(queue3).to(exchange).with(routingkey3);
    }

    @Bean
    public MessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}