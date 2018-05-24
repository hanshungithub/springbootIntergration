package cn.hassan.rabbitmq.message.configs;

import cn.hassan.rabbitmq.message.enums.ExchangeEnum;
import cn.hassan.rabbitmq.message.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 17:19
 * Description: 用户消息队列配置
 */
@Configuration
public class UserRegisterQueueConfiguration {

	/**
	 * 配置用户交换器实例对象
	 * @return 交换器实例
	 */
	@Bean
	public DirectExchange userRegisterDirectExchange() {
        return new DirectExchange(ExchangeEnum.USER_REGISTER_EXCHANGE.getValue());
	}

	/**
	 * 配置用户注册队列对象实例设置持久化队列
	 * @return 消息队列
	 */
	@Bean
	public Queue userRegisterQueue() {
		return new Queue(QueueEnum.USER_REGISTER_QUEUE.getName(),true);
	}

    /**
     * 将用户注册队列绑定到路由交换配置上并设置指定路由键进行转发
     * @return 绑定
     */
	@Bean
	public Binding userRegisterBinding() {
		return BindingBuilder.bind(userRegisterQueue()).to(userRegisterDirectExchange()).with(QueueEnum.USER_REGISTER_QUEUE.getRoutingKey());
	}
}
