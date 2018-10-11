package com.yahier.demo.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试定时任务，注意 应该使用多线程
 *  http://cron.qqe2.com
 */
@Component
public class TestTask {


    /**
     * 每3秒钟 执行一次
     */
    @Scheduled(fixedRate = 3000)
    public void executeSchedule() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("色彩的光芒：" + dateFormat.format(new Date()));
    }

    /**
     * 每到写定的分钟时 执行一次
     * fixme 测试失败  应该是 ? 14 * * * ? 但提示?不合法
     */
    @Scheduled(cron = "0 14 * * * 0 ")
    public void executeSchedule2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("方法2：" + dateFormat.format(new Date()));
    }
}
