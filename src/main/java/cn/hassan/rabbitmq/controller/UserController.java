package cn.hassan.rabbitmq.controller;

import cn.hassan.rabbitmq.pojo.User;
import cn.hassan.rabbitmq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 15:22
 * Description:
 */
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Integer id) {
		return service.getUserById(id);
	}

	@GetMapping("/save")
	public User saveUser(User user){
		return service.saveUser(user);
	}
}
