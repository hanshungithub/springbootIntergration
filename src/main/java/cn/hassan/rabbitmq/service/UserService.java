package cn.hassan.rabbitmq.service;

import cn.hassan.rabbitmq.mapper.UserMapper;
import cn.hassan.rabbitmq.message.QueueMessageService;
import cn.hassan.rabbitmq.message.enums.ExchangeEnum;
import cn.hassan.rabbitmq.message.enums.QueueEnum;
import cn.hassan.rabbitmq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 15:18
 * Description:
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private QueueMessageService producer;

	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	public User saveUser(User user) {
		User result = new User();
		result.setUsername(user.getUsername());
		result.setName(user.getName());
		result.setAge(user.getAge());
		result.setBalance(user.getBalance());
		Integer id = userMapper.saveUser(user);
		result.setId(id);
		producer.send(result,ExchangeEnum.USER_REGISTER_EXCHANGE,QueueEnum.USER_REGISTER_QUEUE);
		return result;
	}
}
