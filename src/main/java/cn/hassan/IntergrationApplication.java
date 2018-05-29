package cn.hassan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时任务
@EnableAsync//异步任务
@MapperScan(value = "cn.hassan.rabbitmq.mapper")//mybatis配置
@EnableRabbit//开启mq
@SpringBootApplication
public class IntergrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntergrationApplication.class, args);
    }
}
