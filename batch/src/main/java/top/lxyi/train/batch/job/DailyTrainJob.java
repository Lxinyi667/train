package top.lxyi.train.batch.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import top.lxyi.train.batch.feign.BusinessFeign;
import top.lxyi.train.common.resp.CommonResp;

import java.util.Date;


@DisallowConcurrentExecution
public class DailyTrainJob implements Job {
    public static final Logger LOG = LoggerFactory.getLogger(DailyTrainJob.class);

    @Resource
    private BusinessFeign businessFeign;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        MDC.put("LOG_ID", System.currentTimeMillis() + RandomUtil.randomString(3));
        LOG.info("生成15天后的车次数据开始");
        Date date = new Date();
        DateTime dateTime = DateUtil.offsetDay(date,15);
        Date offsetDate = dateTime.toJdkDate();
        CommonResp<Object> commonResp = businessFeign.genDaily(offsetDate);
        LOG.info("生成15天后的车次数据结束,结果：{}",commonResp);
    }
}
