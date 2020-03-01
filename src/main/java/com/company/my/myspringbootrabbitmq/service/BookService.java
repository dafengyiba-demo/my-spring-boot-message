package com.company.my.myspringbootrabbitmq.service;

import com.company.my.myspringbootrabbitmq.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {



//    @RabbitListener(queues = {"myQueue"})
//    public void book(Message message){
//        System.out.println(message.getBody());
//        System.out.println(message.getMessageProperties());
//    }

    @RabbitListener(queues = {"myQueue"})
    public void book(Book book){
        System.out.println(book);
    }



}
