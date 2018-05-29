package cn.hassan.asynctask.controller;

import cn.hassan.asynctask.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/29 20:06
 * Description:
 */
@RestController
public class HelloController {

    @Autowired
    private AsyncService service;

    @GetMapping("/hello")
    public String getHello() {
        service.getString();
        return "success";
    }
}
