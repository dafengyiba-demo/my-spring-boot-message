package com.company.my.myspringbootrabbitmq;

import com.company.my.myspringbootrabbitmq.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MySpringBootRabbitmqApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate template;

    @Test
    void amqpAdmin(){
//        amqpAdmin.declareExchange(new DirectExchange("amqp.direct"));
//
//        amqpAdmin.declareQueue(new Queue("amqp.queue"));
//
//        amqpAdmin.declareBinding(new Binding("amqp.queue", Binding.DestinationType.QUEUE,"amqp.direct","amqp.routing.key",null));

//        amqpAdmin.declareQueue(new Queue("test.queue"));

        template.convertAndSend("test.queue","123");

    }

    @Test
    void contextLoads() {

        //Message需要自己去构造，其中包含消息体和消息头
        //template.send(Message message);

        //常用的消息发送方法，message被当做消息体，不需要去特殊构造
        //template.convertAndSend(exchange, routingKey, message);


//        Map<String,Object> map = new HashMap<>();
//        map.put("name","zhangsan");
//        map.put("isOk",true);
//        map.put("age",28);
//        //默认是用jdk的序列化方式序列化后发送出去
//        //可以注入自定义的MessageConverter进行转换，详见config，这样发送和接收都是json格式数据
//        template.convertAndSend("amq.direct","my-queue-rout-key",map);

        Book book = new Book();
        book.setAge(103);
        book.setName("西游记");

        template.convertAndSend("amq.direct","my-queue-rout-key",book);

    }


    //接收数据
    @Test
    void receive(){
        Object myQueue = template.receiveAndConvert("myQueue");
        System.out.println(myQueue.getClass());
        System.out.println(myQueue);
    }

    //广播，发送到交换器，不指定路由键
    @Test
    void sendMessage(){
        Book book = new Book();
        book.setAge(103);
        book.setName("西游记");
        template.convertAndSend("amq.fanout","",book);
    }


}
