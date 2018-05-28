package cn.hassan.rabbitmq;

import cn.hassan.es.pojo.Article;
import cn.hassan.rabbitmq.pojo.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntergrationApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private JestClient jestClient;

    @Test
    public void esTest() throws IOException {
        Article article = new Article();
        article.setId(1);
        article.setAuthor("hassan");
        article.setTitle("java 解析");
        article.setContent("java is very good");
        //构建一个索引
        Index build = new Index.Builder(article).index("books").type("java").build();
        jestClient.execute(build);
    }

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
