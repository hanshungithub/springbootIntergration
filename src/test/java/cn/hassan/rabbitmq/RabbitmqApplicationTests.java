package cn.hassan.rabbitmq;

import cn.hassan.rabbitmq.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;

	/**
	 * rabbitmq 发送消息的时候必须 指定  Exchange
	 */
    @Test
    public void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123));
        rabbitTemplate.convertAndSend("exchange.direct","hassan",new Book("java 8","hassan"));
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("hassan");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
