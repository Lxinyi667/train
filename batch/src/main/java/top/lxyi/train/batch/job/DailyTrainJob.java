package top.lxyi.train.batch.job;

import cn.hutool.core.util.RandomUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


public class DailyTrainJob implements Job {
    public static final Logger LOG = LoggerFactory.getLogger(DailyTrainJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext)throws JobExecutionException{
        MDC.put("LOG_ID",System.currentTimeMillis()+ RandomUtil.randomString(3));
        LOG.info("生成每日车次定时任务开始");
        LOG.info("生成每日车次定时任务结束");
    }
}
