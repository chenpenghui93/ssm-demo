package com.example.toolkit.sample.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenpenghui
 * @date 2021-2-24
 */
@DisallowConcurrentExecution
@Component("hachiQuartzConfig")
public class HachiQuartzConfig implements Job {

    public static final String SCHEDULEJOBKEY = "scheduleJob";

    @Autowired
    private TaskUtils taskUtils;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        QuartzConfig quartzConfig = (QuartzConfig) jobExecutionContext.getMergedJobDataMap().get(SCHEDULEJOBKEY);
        taskUtils.invokMethod(quartzConfig);
    }
}
