package com.itnkc.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 引入amqp依赖
 * 给容器中自动配置了RabbitMqTemplate，AmqpAdmin
 */
@EnableRabbit
@SpringBootApplication
public class RabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }

}
