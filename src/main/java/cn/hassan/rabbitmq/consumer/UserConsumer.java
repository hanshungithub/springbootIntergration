package cn.hassan.rabbitmq.consumer;

import cn.hassan.rabbitmq.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/24 19:36
 * Description:
 */
@Slf4j
@Component
@RabbitListener(queues = "hassan")
public class UserConsumer {

    @RabbitHandler
    public void consumer(User user){
        log.info("消费者 ： " + user);
        System.out.println(user);
    }
}
