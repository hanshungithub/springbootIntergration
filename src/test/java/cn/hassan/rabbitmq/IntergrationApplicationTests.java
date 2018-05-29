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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
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

    @Autowired
    private JavaMailSenderImpl mailSender;


    /**
     * 发送复杂邮件测试
     */
    @Test
    public void complexMailTest() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("复杂邮件发送测试");
        helper.setText("<b>今天开会</b>",true);
        //上传文件
        helper.addAttachment("spring boot",new File("E:\\资料\\项目\\SpringBoot整合篇\\课件\\SpringBoot高级.pdf"));
        helper.setTo("hshanshun@163.com");
        helper.setFrom("hassanbox@qq.com");
        this.mailSender.send(mimeMessage);
    }

    @Test
    public void mailTest() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("QQ 是发送邮件！");
        message.setText("就是测试一下");
        message.setTo("hshanshun@163.com");
        message.setFrom("hassanbox@qq.com");
        mailSender.send(message);
    }

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
