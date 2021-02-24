package com.example.toolkit.sample.quartz;

import com.example.toolkit.mapper.QuartzConfigMapper;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2021-2-24
 */
@Service
public class QuartzTableService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Resource
    private QuartzConfigMapper quartzConfigMapper;

    /**
     * 更新状态
     *
     * @param id
     * @param status
     * @throws Exception
     */
    public void update(Long id, String status)throws Exception {
        QuartzConfig quartzConfig = quartzConfigMapper.selectById(id);
        if (quartzConfig == null) {
            new RuntimeException("未找到指定的定时任务");
        }
        if ("1".equals(status)) {
            quartzConfig.setStatus(ConfigEnum.STATUS_STOP.getCode());
            deleteJob(quartzConfig);
        } else {
            quartzConfig.setStatus(ConfigEnum.STATUS_START.getCode());
            addJob(quartzConfig);
        }
        quartzConfigMapper.updateById(quartzConfig);
    }

    /**
     * 启用所有任务
     */
    public void startJobs(){
        List<QuartzConfig> configList = quartzConfigMapper.selectList(null);
        for (QuartzConfig quartzConfig : configList) {
            if (ConfigEnum.STATUS_START.getCode().equals(quartzConfig.getStatus())) {
                try {
                    addJob(quartzConfig);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 更新cron
     *
     * @param id
     * @param cronSchedule
     */
    public void updateCron(Long id, String cronSchedule){
        QuartzConfig quartzConfig = quartzConfigMapper.selectById(id);
        quartzConfig.setCron(cronSchedule);
        quartzConfigMapper.updateById(quartzConfig);
    }

    /**
     * 新增任务
     *
     * @param config
     * @throws SchedulerException
     */
    private void addJob(QuartzConfig config) throws SchedulerException {
        // 获取调度器
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = this.getJobKey(config);
        // 获取触发器
        TriggerKey triggerKey = TriggerKey.triggerKey(config.getName(), config.getGroupName());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // trigger存在则说明被禁用
        if (trigger == null) {
            // 新建串行任务
            JobDetail jobDetail = JobBuilder.newJob(HachiQuartzConfig.class).withIdentity(jobKey).build();
            jobDetail.getJobDataMap().put(HachiQuartzConfig.SCHEDULEJOBKEY, config);
            // 转换cron表达式
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(config.getCron());
            // 创建触发器并设置cron表达式对象
            trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
            // 在调度器中组合触发器和任务
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(config.getCron());
            // 按照新规则执行
            trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
            // 重启
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

    /**
     * 删除任务
     *
     * @param config
     * @throws SchedulerException
     */
    private void deleteJob(QuartzConfig config) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = this.getJobKey(config);
        scheduler.deleteJob(jobKey);
    }

    private JobKey getJobKey(QuartzConfig quartzConfig){
        return getJobKey(quartzConfig.getName(), quartzConfig.getGroupName());
    }

    private JobKey getJobKey(String name, String group) {
        return JobKey.jobKey(name, group);
    }

}
