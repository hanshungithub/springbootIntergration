package cn.hassan.rabbitmq.message.enums;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 16:44
 * Description:
 */
@Getter
public enum QueueEnum {

	USER_REGISTER_QUEUE		("hassan","hassan")

	;

	/**
	 * 队列名
	 */
	private String name;

	/**
	 * 队列路由键
	 */
	private String routingKey;

	QueueEnum(String name,String routingKey) {
		this.name = name;
		this.routingKey = routingKey;
	}
}
