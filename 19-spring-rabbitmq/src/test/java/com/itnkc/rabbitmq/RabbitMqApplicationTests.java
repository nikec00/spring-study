package com.itnkc.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@Slf4j
@SpringBootTest
public class RabbitMqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
        DirectExchange directExchange = new DirectExchange("hello-java-exchange", true, false);
        amqpAdmin.declareExchange(directExchange);
        log.info("Exchange[{}]创建成功", "hello-java-exchange");
    }

    @Test
    public void createQueue() {
        Queue queue = new Queue("hello-java-queue", true, false, false);
        amqpAdmin.declareQueue(queue);
        log.info("queue[{}]创建成功", "hello-java-queue");
    }

    @Test
    public void binding() {
        // String destination,(目的地)
        // Binding.DestinationType destinationType,(目的地类型)WWW
        // String exchange,(交换机)
        // String routingKey,(路由键)
        // @Nullable Map<String, Object> arguments(聚合参数)
        Binding binding = new Binding("hello-java-queue", Binding.DestinationType.QUEUE,
                "hello-java-exchange", "hello.java", new HashMap<>());
        amqpAdmin.declareBinding(binding);
    }

    @Test
    public void sendMessageTest() {
//        User user = new User();
//        user.setName("nike");
//        user.setGender("男");
//        user.setAge(23);
//        rabbitTemplate.convertAndSend("hello-java-exchange", "hello.java", user);
    }

    /**
     * queue:声明需要监听的所有队列
     * @param message
     */
    @RabbitListener(queues = {"hello-java-queue"})
    public void rabbitListener(Object message) {
        System.out.println("接收到了消息...内容：" + message + "==>类型：" + message);
    }

}
