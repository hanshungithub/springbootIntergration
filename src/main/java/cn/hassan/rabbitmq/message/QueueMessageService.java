package cn.hassan.rabbitmq.message;

import cn.hassan.rabbitmq.message.enums.ExchangeEnum;
import cn.hassan.rabbitmq.message.enums.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 16:04
 * Description: 发送消息到rabbitmq队列抽象接口
 */
public interface QueueMessageService extends RabbitTemplate.ConfirmCallback {

	void send(Object msg, ExchangeEnum exchangeEnum, QueueEnum queueEnum);
}
