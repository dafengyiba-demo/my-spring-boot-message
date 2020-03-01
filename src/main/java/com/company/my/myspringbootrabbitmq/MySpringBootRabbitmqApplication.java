package com.company.my.myspringbootrabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 自动配置:
 *  1.自动配置类RabbitAutoConfiguration
 *  2.自动配置类里配置了连接工厂CachingConnectionFactory
 *  3.配置属性在RabbitProperties类中
 *  4.RabbitTemplate:给消息发送和接收消息
 *  5.AmqpAdmin:
 *      创建exchange或者queue
 *  6.@RabbitListener:
 *      开启监听队列消息，@RabbitListener所在的类必须注入spring容器
 *
 *
 * rabbitmq知识补充：
 *
 */
@SpringBootApplication
//@EnableRabbit
public class MySpringBootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootRabbitmqApplication.class, args);
    }

}
