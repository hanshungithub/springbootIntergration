package cn.hassan.rabbitmq.message.impl;

import cn.hassan.rabbitmq.message.QueueMessageService;
import cn.hassan.rabbitmq.message.enums.ExchangeEnum;
import cn.hassan.rabbitmq.message.enums.QueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 16:48
 * Description: rabbitmq 消息队列发送实现类
 */
@Slf4j
@Component
public class QueueMessageServiceImpl implements QueueMessageService {


	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 发送消息模板
	 * @param msg 消息实体
	 * @param exchangeEnum 交换器
	 * @param queueEnum 队列名
	 */
	@Override
	public void send(Object msg, ExchangeEnum exchangeEnum, QueueEnum queueEnum) {
		//设置回调为当前类对象
		rabbitTemplate.setConfirmCallback(this);
		//构建回调id为UUID
		CorrelationData correlationDataId = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(exchangeEnum.getValue(),queueEnum.getName(),msg,correlationDataId);
	}

	/**
	 * 消息回调确认方法
	 * @param correlationData  Base class for correlating publisher confirms to sent messages.
	 * @param ack true for ack, false for nack
	 * @param cause An optional cause, for nack, when available, otherwise null.
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("回调id：" + correlationData.getId());
		log.info("回调id：" + correlationData.getId());
		if (ack) {
			System.out.println("消息发送成功");
            log.info("消息发送成功");
		}else {
			System.out.println("消息发送失败");
            log.error("消息发送失败");
		}
	}
}
