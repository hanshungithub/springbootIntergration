package cn.hassan.rabbitmq.message.enums;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 16:11
 * Description: 交换器枚举类
 */
@Getter
public enum ExchangeEnum {

	USER_REGISTER_EXCHANGE	("exchange.direct")

	;

	private String value;

	ExchangeEnum(String value) {
		this.value = value;
	}
}
