package cn.hassan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "cn.hassan.rabbitmq.mapper")
@EnableRabbit
@SpringBootApplication
public class IntergrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntergrationApplication.class, args);
    }
}