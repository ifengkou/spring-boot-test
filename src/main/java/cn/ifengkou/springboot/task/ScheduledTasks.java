package cn.ifengkou.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2017/5/17 下午10:17.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    @Scheduled(initialDelay=1000, fixedRate=5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}