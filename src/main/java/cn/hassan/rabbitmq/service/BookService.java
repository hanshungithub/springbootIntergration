package cn.hassan.rabbitmq.service;

import cn.hassan.rabbitmq.pojo.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/23 22:35
 * Description:
 */
@Service
public class BookService {

    @RabbitListener(queues = "hassan")
    public void receive(Book book) {
        System.out.println("收到消息--->" + book);
    }
}
