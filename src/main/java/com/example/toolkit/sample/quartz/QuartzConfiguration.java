package com.example.toolkit.sample.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz配置类
 *
 * @author chenpenghui
 * @date 2021-2-24
 */
@Configuration
public class QuartzConfiguration {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        // 使用自定义工厂类，防止不能注入的问题
        factoryBean.setJobFactory(hachiQuartzJobFactory());
        // 启动时更新已存在的job
        factoryBean.setOverwriteExistingJobs(true);
        // 启动后延迟5s执行
        factoryBean.setStartupDelay(5);
        return factoryBean;
    }

    @Bean
    public HachiQuartzJobFactory hachiQuartzJobFactory() {
        return new HachiQuartzJobFactory();
    }
}
