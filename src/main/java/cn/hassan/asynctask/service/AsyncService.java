package cn.hassan.asynctask.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/29 20:03
 * Description:
 */
@Service
@Slf4j
public class AsyncService {

    @Async
    public void getString() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            log.error("线程出错");
        }
        System.out.println("service 方法打印了");
    }
}
