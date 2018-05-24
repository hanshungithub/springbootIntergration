package cn.hassan.rabbitmq.mapper;

import cn.hassan.rabbitmq.pojo.User;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 15:07
 * Description:
 */
public interface UserMapper {

	User getUserById(Integer id);

	Integer saveUser(User user);
}
