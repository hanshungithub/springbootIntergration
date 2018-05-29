package cn.hassan.asynctask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/29 20:16
 * Description:
 */
@Service
public class ScheduleService {

    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        System.out.println("service hello ...");
    }
}
