package top.lxyi.train.batch.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.lxyi.train.batch.job.TestJob;

@Configuration
public class QuartzConfig {

    /**
     * 声明一个任务
     *
     * @return 任务
     */
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(TestJob.class)
                .withIdentity("TestJob", "test")
                .storeDurably()
                .build();
    }

    /**
     * 声明一个触发器，什么时候触发这个任务
     *
     * @return 触发器
     */
    @Bean
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("trigger", "trigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
                .build();
    }
}